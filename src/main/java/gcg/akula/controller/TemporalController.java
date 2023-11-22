package gcg.akula.controller;

import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.NotFoundException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;

@Controller
public class TemporalController {

    /*@Inject
    CourseRepository courseRepository;

    @Get("/")
    public HttpResponse get() {
        Optional<Course> x = courseRepository.findById(1L);
        return HttpResponse.ok(x.orElse(null));
    }*/

    @Error(global = true, status = HttpStatus.NOT_FOUND)
    public ApplicationResponse<String> notFound(HttpRequest request) {
        return ApplicationResponse.fail(HttpStatus.NOT_FOUND, request.getPath(), new NotFoundException(request.getPath()));
    }
}
