package gcg.akula.repository;

import gcg.akula.entity.jpa.Course;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public abstract class CourseRepository implements PageableRepository<Course, Long> {

}
