package gcg.akula.repository;

import gcg.akula.entity.jpa.UserTest;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class UserTestRepository implements CrudRepository<UserTest, Long> {
}
