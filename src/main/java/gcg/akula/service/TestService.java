package gcg.akula.service;


import gcg.akula.entity.dto.test.TestDto;
import gcg.akula.repository.TestRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class TestService {
    
    @Inject
    TestRepository testRepository;

    public Optional<TestDto> getCourseFlat(long tid) {
        return  testRepository.findById(tid).map(TestDto::new);
    }

    public TestDto save(TestDto test) {
        return new TestDto(
                testRepository.save(test.toEntity())
        );
    }

    public void delete(Long id){
        testRepository.deleteById(id);
    }

    public TestDto update(TestDto test) {
        return new TestDto(
                testRepository.update(test.toEntity())
        );
    }


}
