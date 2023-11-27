package gcg.akula.repository;

import gcg.akula.entity.jpa.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class UserRepository implements CrudRepository<User, Long> {
    @Inject
    EntityManager entityManager;

    @ReadOnly
    public Optional<User> getMe() {
        final long id = 1L;//TODO: change
        List<User> user = entityManager.createQuery("select U from User U " +
                        "left join fetch U.boss B " +
                        "left join fetch U.photo P " +
                        "left join fetch U.department D " +
                        "where U.id=(:id)", User.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList();
        return user.isEmpty() ? Optional.empty() : Optional.of(user.get(0));
    }

    @Deprecated
    @Transactional
    public int sync(String sql) {
        return entityManager
                .createNativeQuery(sql)
                .executeUpdate();
    }
}
