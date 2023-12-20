package gcg.akula.repository;


import gcg.akula.entity.jpa.Course;
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
public abstract class TestRepository implements CrudRepository<Test, Long> {

    @PersistenceContext
    EntityManager manager;

    @ReadOnly
    public Page<Test> findById(Long id, Pageable pageable){
        long count = manager
                .createQuery("select distinct count(t) from Test as t", Long.class)
                .getSingleResult();
        List<Test> list = manager.createQuery("select distinct t from Test as t " +
                        "left join fetch t.questions q " +
                        "where t.id = :id", Test.class)
                .setParameter("id", id)
                .setMaxResults(pageable.getSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
        return Page.of(list, pageable, count);
    }
}
