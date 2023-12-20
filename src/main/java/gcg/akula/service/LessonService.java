package gcg.akula.service;


import gcg.akula.entity.dto.CourseDto;
import gcg.akula.entity.dto.lesson.FlatLessonDto;
import gcg.akula.entity.dto.lesson.LessonDto;
import gcg.akula.entity.jpa.Lesson;
import gcg.akula.repository.LessonRepository;
import io.micronaut.data.model.Page;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;


/*
* TODO:
*  1. Сделать проверку на прохождение урока
*
* */
@Singleton
public class LessonService {

    @Inject
    LessonRepository lessonRepository;

    @Inject
    UserLessonService userLessonService;
    public Optional<LessonDto> getLessonsById(long lid, long uid){
        return lessonRepository.findById(lid).map(m -> {
            LessonDto ld = new LessonDto(m);
            ld.setCompleted(userLessonService.isCompleted(lid, uid));
            return ld;
        });
    }

    public LessonDto save(LessonDto body) {
        return new LessonDto(
                lessonRepository.save(body.toEntity())
        );
    }

    public LessonDto update(LessonDto update){
        return new LessonDto(
                lessonRepository.update(update.toEntity())
        );
    }
}
