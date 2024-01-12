package gcg.akula.service;


import gcg.akula.entity.dto.course.CourseDto;
import gcg.akula.entity.dto.lesson.LessonDto;
import gcg.akula.entity.jpa.Lesson;
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
        return lessonRepository.findById(lid).map(m ->
         (LessonDto) new LessonDto(m)
                 .setCompleted(
                         userLessonService.isCompleted(lid, uid)
                 )
        );
    }

    public LessonDto save(LessonDto body, Long id) {
        Lesson target = body.toEntity();
        target.setCid(new CourseDto().setId(id).toEntity());
        return new LessonDto(
                lessonRepository.save(target)
        );
    }

    public Optional<LessonDto> update(LessonDto update){
        return lessonRepository.updateWithCourse(update.toEntity()).map(LessonDto::new);
    }

    public void delete(Long id) {
        lessonRepository.disable(id);
    }

    public void enable(Long id) {
        lessonRepository.enable(id);
    }
}
