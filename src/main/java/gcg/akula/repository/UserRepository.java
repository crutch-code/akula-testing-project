package gcg.akula.repository;


import gcg.akula.entity.jpa.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class UserRepository implements CrudRepository<User, Long> {
}
