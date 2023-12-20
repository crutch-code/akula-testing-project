package gcg.akula.repository;

import gcg.akula.entity.jpa.Course;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class CourseRepository implements PageableRepository<Course, Long> {


    @PersistenceContext
    EntityManager manager;


}
