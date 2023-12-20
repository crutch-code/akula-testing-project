package gcg.akula.service;


import gcg.akula.repository.QuestionRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class QuestionService {

    @Inject
    QuestionRepository questionRepository;

}
