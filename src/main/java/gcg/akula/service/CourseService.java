package gcg.akula.service;

import gcg.akula.entity.dto.CourseDto;
import gcg.akula.entity.dto.CourseDto;
import gcg.akula.repository.CourseRepository;
import gcg.akula.repository.NewsRepository;
import gcg.akula.repository.UserCourseRepository;
import gcg.akula.repository.UserLessonRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.stream.Collectors;

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
        courseRepository.deleteById(id);
    }

    public CourseDto update(CourseDto update){
        return new CourseDto(
                courseRepository.update(update.toEntity())
        );
    }

}
