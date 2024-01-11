package gcg.akula.service;


import gcg.akula.entity.dto.lesson.LessonDto;
import gcg.akula.repository.LessonRepository;
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

    public void delete(Long id) {
        lessonRepository.disable(id);
    }

    public void enable(Long id) {
        lessonRepository.enable(id);
    }
}
