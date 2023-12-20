package gcg.akula.service;

import gcg.akula.repository.UserLessonRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class UserTestService {

    @Inject
    UserLessonRepository userLessonRepository;


}
