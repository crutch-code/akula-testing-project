package gcg.akula.repository;

import gcg.akula.entity.jpa.Comparison;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class ComparisonRepository implements CrudRepository<Comparison, Long> {
}
