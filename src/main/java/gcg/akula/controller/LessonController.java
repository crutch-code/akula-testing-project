package gcg.akula.controller;


import gcg.akula.entity.dto.lesson.LessonDto;
import gcg.akula.entity.jpa.Lesson;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.NotFoundException;
import gcg.akula.service.LessonService;
import gcg.akula.service.UserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller("/api/lesson")
public class LessonController{

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Inject
    LessonService lessonService;

    @Inject
    UserService userService;


    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<LessonDto> getLessonsById(long id) {
        try {
            Optional<LessonDto> lessons = lessonService.getLessonsById(
                    id,
                    userService.getCurrent().orElseThrow().getId()
            );
            return lessons
                    .map(ApplicationResponse::ok)
                    .orElseGet(() -> ApplicationResponse.fail(
                            HttpStatus.NOT_FOUND, new NotFoundException(Lesson.class.getName() + "[" + id + "]"))
                    );
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Post(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<LessonDto> createLesson(@Body LessonDto body) {
        try {
            return ApplicationResponse.ok(
                    lessonService.save(body)
            );

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> delete(
            long id
    ) {
        try {
            lessonService.delete(id);
            return ApplicationResponse.ok("Курс удалён");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Get(value = "/enable/{id}")
    public ApplicationResponse<String> enable(
            long id
    ) {
        try {
            lessonService.delete(id);
            return ApplicationResponse.ok("Курс удалён");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<LessonDto> updateLesson(
            @Body LessonDto update
    ) {
        try {
            return ApplicationResponse.ok(lessonService.update(update));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }



}
