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

    public void setId(Long id) {
        this.id = id;
    }

    public String getId1c() {
        return id1c;
    }

    public void setId1c(String id1c) {
        this.id1c = id1c;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto getBoss() {
        return boss;
    }

    public void setBoss(UserDto boss) {
        this.boss = boss;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public StorageDto getPhoto() {
        return photo;
    }

    public void setPhoto(StorageDto photo) {
        this.photo = photo;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
