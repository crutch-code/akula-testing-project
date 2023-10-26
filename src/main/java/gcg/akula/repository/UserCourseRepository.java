package gcg.akula.repository;


import gcg.akula.entity.jpa.UserCourse;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public abstract class UserCourseRepository implements CrudRepository<UserCourse, Long> {
}
