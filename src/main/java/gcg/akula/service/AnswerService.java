package gcg.akula.service;

import gcg.akula.repository.AnswerRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AnswerService {

    @Inject
    AnswerRepository answerRepository;

}
