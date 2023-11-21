package gcg.akula.controller;

import gcg.akula.entity.dto.UserDto;
import gcg.akula.entity.jpa.User;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.UserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import javassist.NotFoundException;

import java.util.Optional;

@Controller("/api/user")
public class UserController {

    @Inject
    UserService userService;

    @Get("/{id}")
    public ApplicationResponse<UserDto> getById(long id) {
        Optional<UserDto> user = userService.getById(id);
        if(user.isPresent()) {
            return ApplicationResponse.ok(user.get());
        }
        return ApplicationResponse.fail(HttpStatus.NOT_FOUND, new NotFoundException(User.class.getName()));
    }
}
