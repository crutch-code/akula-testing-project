package gcg.akula.repository;

import gcg.akula.entity.jpa.News;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
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
                .createQuery("select distinct N from News N " +
                        "left join fetch N.author A " +
                        "left join fetch N.photo " +
                        "left join fetch A.photo " +
                        "order by N.publishDate desc", News.class)
                .setMaxResults(pageable.getSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
        return Page.of(news, pageable, count);
    }

    @Transactional
    public void disable(Long id){
        entityManager.createQuery("update News as t set t.disabled = true where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void enable(Long id){
        entityManager.createQuery("update News as t set t.disabled = false where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
