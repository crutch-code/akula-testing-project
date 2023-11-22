package gcg.akula.controller;

import gcg.akula.entity.dto.TeachDto;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.TeachService;
import gcg.akula.service.UserService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/api/teach")
public class TeachController {

    @Inject
    TeachService teachService;
    @Inject
    UserService userService;

    @Get("/")
    public ApplicationResponse<Page<TeachDto>> getCoursesForUser(Pageable pageable) {
        return ApplicationResponse.ok(teachService.getAssignedToUser(userService.getCurrent().get().getId(), pageable));
    }
}
