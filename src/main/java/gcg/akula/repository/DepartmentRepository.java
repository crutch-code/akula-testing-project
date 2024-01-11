package gcg.akula.repository;

import gcg.akula.entity.jpa.Department;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public abstract class DepartmentRepository implements CrudRepository<Department, Long> {

    @PersistenceContext
    EntityManager manager;

    @Transactional
    public void disable(Long id){
        manager.createQuery("update Department as t set t.disabled = true where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void enable(Long id){
        manager.createQuery("update Department as t set t.disabled = false where t.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
