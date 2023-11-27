package gcg.akula.service;

import gcg.akula.entity.dto.UserDto;
import gcg.akula.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

@Singleton
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    UserRepository userRepository;

    public Optional<UserDto> getCurrent() {
        return userRepository.getMe().map(UserDto::new);
    }

    public Optional<UserDto> getById(long id) {
        return userRepository.findById(1L).map(UserDto::new);
    }

    @Deprecated
    public int sync(String csv) {
        StringBuilder sql = new StringBuilder();
        try {
            Arrays.stream(csv.split("\r\n"))
                    .skip(1L)//Skip header
                    .forEach(line -> {
                        //УИН;Пользователь;Подразделение;ИмяВхода;ДатаСоздания;Удален;АдресЭП;Должность;Хэш
                        String[] fields = line.split(";");
                        sql.append(String.format("insert into department(name) values ('%s') on conflict do nothing;", fields[2]));
                        sql.append(String.format("insert into \"user\"(\"1c_id\", fio, login, password, disabled, did) select '%s', '%s', '%s', '%s', %s, (select id from department where name='%s');%n%n",
                                fields[0], fields[1], fields[3], fields.length < 8 ? "" : fields[8], fields[5].equalsIgnoreCase("нет") ? "false" : "true", fields[2]));
                    });
            return userRepository.sync(sql.toString());
        } catch(Exception ex) {
            logger.error(ex.getMessage());
            return -1;
        }
    }
}
