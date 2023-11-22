package gcg.akula.service;

import gcg.akula.entity.dto.UserDto;
import gcg.akula.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class UserService {

    @Inject
    UserRepository userRepository;

    public Optional<UserDto> getCurrent() {
        return userRepository.getMe().map(UserDto::new);
    }

    public Optional<UserDto> getById(long id) {
        return userRepository.findById(1L).map(UserDto::new);
    }
}
