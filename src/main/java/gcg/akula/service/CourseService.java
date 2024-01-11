package gcg.akula.service;

import gcg.akula.entity.dto.course.CourseDto;
import gcg.akula.repository.CourseRepository;
import gcg.akula.repository.UserCourseRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class CourseService {

    @Inject
    CourseRepository courseRepository;

    @Inject
    UserLessonService userLessonService;

    @Inject
    UserCourseRepository userCourseRepository;

    public Optional<CourseDto> getCourseFlat(long cid, long uid) {
        return  courseRepository
                .findById(cid)
                .map(m -> {
                     CourseDto val = new CourseDto(m);
                     val.getLessons().forEach(
                             it -> it.setCompleted(userLessonService.isCompleted(it.getId(), uid))
                     );
                     return val;
                });
    }

    public CourseDto save(CourseDto course) {
        return new CourseDto(
                courseRepository.save(course.toEntity())
        );
    }

    public void delete(Long id){
        courseRepository.disable(id);
    }

    public void enable(Long id){
        courseRepository.enable(id);
    }

    public CourseDto update(CourseDto update){
        return new CourseDto(
                courseRepository.update(update.toEntity())
        );
    }

}
