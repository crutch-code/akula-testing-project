package gcg.akula.repository;

import gcg.akula.entity.jpa.Answer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class AnswerRepository implements CrudRepository<Answer, Long> {
}
