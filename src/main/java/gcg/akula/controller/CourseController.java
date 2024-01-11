package gcg.akula.controller;

import gcg.akula.entity.dto.course.CourseDto;
import gcg.akula.entity.jpa.Course;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.NotFoundException;
import gcg.akula.service.CourseService;
import gcg.akula.service.UserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller("/api/course")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Inject
    CourseService courseService;

    @Inject
    UserService userService;


    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<CourseDto> getCourseById(long id) {
        try {
            Optional<CourseDto> news = courseService.getCourseFlat(
                    id,
                    userService.getCurrent().orElseThrow().getId()
            );
            return news
                    .map(ApplicationResponse::ok)
                    .orElseGet(() -> ApplicationResponse.fail(
                            HttpStatus.NOT_FOUND, new NotFoundException(Course.class.getName() + "[" + id + "]"))
                    );
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Post(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<CourseDto> createNewCourse(@Body CourseDto body) {
        try {
            return ApplicationResponse.ok(
                    courseService.save(body)
            );

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> deleteCourse(
            long id
    ) {
        try {
            courseService.delete(id);
            return ApplicationResponse.ok("Курс удалён");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }



    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<CourseDto> updateCourse(
            @Body CourseDto update
    ) {
        try {
            return ApplicationResponse.ok(courseService.update(update));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
