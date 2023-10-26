package gcg.akula.repository;

import gcg.akula.entity.jpa.Question;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class QuestionRepository implements CrudRepository<Question, Long> {
}
