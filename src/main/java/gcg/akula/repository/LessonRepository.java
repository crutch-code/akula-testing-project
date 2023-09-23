package gcg.akula.repository;

import gcg.akula.entity.jpa.Lesson;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public abstract class LessonRepository implements PageableRepository<Lesson, Long>  {
}
