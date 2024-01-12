package gcg.akula.repository;

import gcg.akula.entity.jpa.Lesson;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public abstract class LessonRepository implements PageableRepository<Lesson, Long>  {


    @PersistenceContext
    EntityManager manager;

    @ReadOnly
    public Page<Lesson> findById(Long id, Pageable pageable){
        long count = manager
                .createQuery("select distinct count(t) from Lesson as t", Long.class)
                .getSingleResult();
        List<Lesson> list = manager.createQuery("select distinct t from Lesson as t " +
                        "left join fetch t.tests " +
                        "where t.id = :id", Lesson.class)
                .setParameter("id", id)
                .setMaxResults(pageable.getSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
        return Page.of(list, pageable, count);
    }

    public Optional<Lesson> updateWithCourse(Lesson entity){
         AtomicReference<Optional<Lesson>> target = new AtomicReference<>(findById(entity.getId()));
         target.get().ifPresent(v ->{
             entity.setCid(target.get().get().getCid());
             target.set(Optional.of(
                     update(entity)
             ));
         });
         return target.get();
    }

    @Transactional
    public void disable(Long id){
        manager.createQuery("update Lesson as t set t.disabled = true where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void enable(Long id){
        manager.createQuery("update Lesson as t set t.disabled = false where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
