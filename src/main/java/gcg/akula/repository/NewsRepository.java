package gcg.akula.repository;

import gcg.akula.entity.jpa.News;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public abstract class NewsRepository implements CrudRepository<News, Long> {

    @Inject
    private EntityManager entityManager;

    @ReadOnly
    public Page<News> findAll(Pageable pageable) {
        long count = entityManager
                .createQuery("select count(N) from News N", Long.class)
                .getResultList()
                .get(0);
        List<News> news = entityManager
                .createQuery("select distinct N from News N left join fetch N.author order by N.publishDate", News.class)
                .setMaxResults(pageable.getSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
        return Page.of(news, pageable, count);
    }
}
