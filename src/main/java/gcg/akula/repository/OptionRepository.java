package gcg.akula.repository;

import gcg.akula.entity.jpa.Option;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class OptionRepository implements CrudRepository<Option, Long> {
}
