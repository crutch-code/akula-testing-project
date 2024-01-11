package gcg.akula.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import gcg.akula.entity.jpa.User;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
public class UserDto implements DTO<User> {
    private Long id;
    private String id1c;
    private String fio;
    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;
    private UserDto boss;
    private DepartmentDto department;
    private StorageDto photo;
    @NotNull
    private Boolean disabled = false;


    @Override
    public User toEntity() {
        return new User(
                id, id1c, fio, login,
                password, boss == null ? null : boss.toEntity(),
                department.toEntity(), photo.toEntity(), disabled
        );
    }

    public UserDto() {
    }

    public UserDto(User user) {
        id = user.getId();
        id1c = user.getId1c();
        fio = user.getFio();
        login = user.getLogin();
        password = user.getPassword();
        if (user.getBoss() != null) {
            boss = new UserDto(user.getBoss());
        }
        department = new DepartmentDto(user.getDepartment());
        photo = new StorageDto(user.getPhoto(), true);
        disabled = user.getDisabled();
    }


    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getId1c() {
        return id1c;
    }

    public UserDto setId1c(String id1c) {
        this.id1c = id1c;
        return this;
    }

    public String getFio() {
        return fio;
    }

    public UserDto setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDto getBoss() {
        return boss;
    }

    public UserDto setBoss(UserDto boss) {
        this.boss = boss;
        return this;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public UserDto setDepartment(DepartmentDto department) {
        this.department = department;
        return this;
    }

    public StorageDto getPhoto() {
        return photo;
    }

    public UserDto setPhoto(StorageDto photo) {
        this.photo = photo;
        return this;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public UserDto setDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }
}
