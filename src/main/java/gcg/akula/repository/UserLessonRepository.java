package gcg.akula.repository;

import gcg.akula.entity.jpa.UserLesson;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class UserLessonRepository implements CrudRepository<UserLesson, Long> {
}
