package gcg.akula.entity.jpa;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Comment;

@Serdeable
@Comment("Пользователь")
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Comment("1С ID")
    @Column(name = "1c_id", length = Integer.MAX_VALUE)
    private String id1c;

    @Comment("ФИО")
    @Column(name = "fio", nullable = false, length = Integer.MAX_VALUE)
    private String fio;

    @Comment("Логин")
    @Column(name = "login", nullable = false, length = Integer.MAX_VALUE)
    private String login;

    @Comment("Пароль")
    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("Начальник")
    @JoinColumn(name = "boss")
    private User boss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "did", nullable = false)
    private Department department;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "photo", nullable = false)
    private Storage photo;

    @NotNull
    @Column(name = "disabled", nullable = false)
    private Boolean disabled = false;


    public User() {
    }


    public User(
            Long id, String id1c, String fio,
            String login, String password, User boss,
            Department department, @NotNull Storage photo, @NotNull Boolean disabled
    ) {
        this.id = id;
        this.id1c = id1c;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.boss = boss;
        this.department = department;
        this.photo = photo;
        this.disabled = disabled;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Storage getPhoto() {
        return photo;
    }

    public void setPhoto(Storage photo) {
        this.photo = photo;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}