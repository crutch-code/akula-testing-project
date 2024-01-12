package gcg.akula.controller;


import gcg.akula.entity.dto.course.CourseDto;
import gcg.akula.entity.dto.test.TestDto;
import gcg.akula.entity.jpa.Course;
import gcg.akula.entity.jpa.Test;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.NotFoundException;
import gcg.akula.service.TestService;
import gcg.akula.service.UserService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/api/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Inject
    TestService testService;

    @Inject
    UserService userService;

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<TestDto> getTestById(
        long id
    ) throws NotFoundException {
        return testService.getTestById(id)
                .map(ApplicationResponse::ok)
                .orElseThrow(()-> new NotFoundException(Test.class.getName() + "[" + id + "]"));
    }

    @Post(value = "/{lid}", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<TestDto> createNewTest(
            @Body TestDto body,
            long lid
    ) {
        return ApplicationResponse.ok(testService.save(body, lid));
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> deleteTest(
            long id
    ) {
        throw new NotImplementedException("REST API метод DELETE /api/test/{id} ещё не имплементирован");
//        testService.delete(id);
//        return ApplicationResponse.ok("Тест удалён");
    }

    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<TestDto> updateTest(
            @Body TestDto update
    ) {
        throw new NotImplementedException("REST API метод DELETE /api/test/{id} ещё не имплементирован");
//        return ApplicationResponse.ok(testService.update(update));
    }

}
