package gcg.akula.service;

import gcg.akula.entity.dto.lesson.UserLessonDto;
import gcg.akula.repository.UserLessonRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserLessonService {

    @Inject
    private UserLessonRepository userLessonRepository;

    public Boolean isCompleted(Long lid, Long uid){
        return userLessonRepository.getStatus(lid, uid).orElse(0) == 100;
    }

    public UserLessonDto assignToLesson(UserLessonDto target) {
        return new UserLessonDto(
            userLessonRepository.save(
                target.toEntity()
            )
        );
    }
}
