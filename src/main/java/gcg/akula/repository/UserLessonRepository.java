package gcg.akula.repository;

import gcg.akula.entity.jpa.UserLesson;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@Repository
public abstract class UserLessonRepository implements CrudRepository<UserLesson, Long> {

    @PersistenceContext
    EntityManager manager;

    @ReadOnly
    public Optional<Integer> getStatus(Long lid, Long uid){
        return manager.createQuery("select t.status from UserLesson t where t.lid.id =:lid and t.uid.id=:uid", Integer.class)
                .setParameter("lid", lid)
                .setParameter("uid", uid)
                .getResultList()
                .stream()
                .findFirst();

    }

    @Transactional
    public void updateStatus(Long lid, Long uid, Integer score){
        manager.createQuery("update UserLesson t set t.status =:score " +
                "where t.lid = :lid and t.uid = uid")
                .setParameter("lid", lid)
                .setParameter("uid", uid)
                .setParameter("score", score)
                .executeUpdate();
    }

}
