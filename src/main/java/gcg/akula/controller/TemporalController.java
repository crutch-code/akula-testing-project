package gcg.akula.controller;

import gcg.akula.entity.jpa.Course;
import gcg.akula.repository.CourseRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.Optional;

@Controller("/test")
public class TemporalController {

    @Inject
    CourseRepository courseRepository;

    @Get("/")
    public HttpResponse get() {
        Optional<Course> x = courseRepository.findById(1L);
        return HttpResponse.ok(x.orElse(null));
    }
}
