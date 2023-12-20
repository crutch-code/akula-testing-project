package gcg.akula.repository;

import gcg.akula.entity.jpa.Answer;
import gcg.akula.entity.jpa.Test;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public abstract class AnswerRepository implements CrudRepository<Answer, Long> {


    @PersistenceContext
    EntityManager manager;

    @ReadOnly
    public Page<Answer> findById(Long id, Pageable pageable){
        long count = manager
                .createQuery("select distinct count(t) from Answer as t", Long.class)
                .getSingleResult();
        List<Answer> list = manager.createQuery("select distinct t from Answer as t " +
                        "left join fetch t.qid q " +
                        "where t.id = :id", Answer.class)
                .setParameter("id", id)
                .setMaxResults(pageable.getSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
        return Page.of(list, pageable, count);
    }

}
