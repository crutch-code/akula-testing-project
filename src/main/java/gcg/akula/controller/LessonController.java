package gcg.akula.controller;


import gcg.akula.entity.dto.lesson.LessonDto;
import gcg.akula.entity.jpa.Lesson;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.BadRequestException;
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
    public ApplicationResponse<LessonDto> getLessonsById(long id) throws NotFoundException {
        Optional<LessonDto> lessons = lessonService.getLessonsById(
                id,
                userService.getCurrent().orElseThrow().getId()
        );
        return lessons
                .map(ApplicationResponse::ok)
                .orElseThrow(() -> new NotFoundException(Lesson.class.getName() + "[" + id + "]"));
    }

    @Post(value = "/{cid}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<LessonDto> createLesson(
            @Body LessonDto body,
            long cid
    ) {
        return ApplicationResponse.ok(
                    lessonService.save(body, cid)
        );
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> delete(
            long id
    ) {
        lessonService.delete(id);
        return ApplicationResponse.ok("Курс удалён");
    }

    @Get(value = "/enable/{id}")
    public ApplicationResponse<String> enable(
            long id
    ) {
        lessonService.delete(id);
        return ApplicationResponse.ok("Курс восстановлен");
    }

    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<LessonDto> updateLesson(
            @Body LessonDto update
    ) throws BadRequestException {
            return lessonService.update(update).map(ApplicationResponse::ok).orElseThrow(
                    ()-> new BadRequestException("Не найден урок с таким идентификатором," +
                    " или есть нарушение целостности в теле запроса", update)
            );
    }



}
