package gcg.akula.service;

import gcg.akula.entity.dto.course.UserCourseDto;
import gcg.akula.entity.dto.lesson.UserLessonDto;
import gcg.akula.repository.UserCourseRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserCourseService {

    @Inject
    UserCourseRepository userCourseRepository;


    public UserCourseDto assignToCourse(UserCourseDto target) {
        return new UserCourseDto(
                userCourseRepository.save(
                        target.toEntity()
                )
        );
    }
}
