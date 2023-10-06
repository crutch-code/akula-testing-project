package gcg.akula.repository;


import gcg.akula.entity.jpa.Test;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class TestRepository implements CrudRepository<Test, Long> {
}
