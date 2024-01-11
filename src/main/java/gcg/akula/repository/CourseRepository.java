package gcg.akula.repository;

import gcg.akula.entity.jpa.Course;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public abstract class CourseRepository implements PageableRepository<Course, Long> {

    @PersistenceContext
    EntityManager manager;


    @Transactional
    public void disable(Long id){
        manager.createQuery("update Course as t set t.disabled = true where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void enable(Long id){
        manager.createQuery("update Course as t set t.disabled = false where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
