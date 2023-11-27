package gcg.akula.controller;

import gcg.akula.entity.dto.UserDto;
import gcg.akula.entity.jpa.User;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.NotFoundException;
import gcg.akula.service.UserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller("/api/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Inject
    UserService userService;

    @Get("/{id}")
    public ApplicationResponse<UserDto> getById(long id) {
        Optional<UserDto> user = userService.getById(id);
        if (user.isPresent()) {
            return ApplicationResponse.ok(user.get());
        }
        return ApplicationResponse.fail(HttpStatus.NOT_FOUND, new NotFoundException(User.class.getName()));
    }

    @Get("/me")
    public ApplicationResponse<UserDto> getMe() {
        Optional<UserDto> user = userService.getCurrent();
        if (user.isPresent()) {
            return ApplicationResponse.ok(user.get());
        }
        return ApplicationResponse.fail(HttpStatus.NOT_FOUND, new NotFoundException(User.class.getName()));//TODO: it's logout
    }

    @Put(value = "/sync", consumes = MediaType.ALL)
    public ApplicationResponse<Integer> syncUsers(byte[] csv) {
        String csvFile = new String(csv);
        int result = userService.sync(csvFile);
        if(result != -1) {
            return ApplicationResponse.ok(result);
        }
        return ApplicationResponse.fail(HttpStatus.RESET_CONTENT, result, null);
    }
}
