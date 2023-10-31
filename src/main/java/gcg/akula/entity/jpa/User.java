package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Comment("Пользователь")
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public User() {
    }

    public User(Long id, String id1c, String fio, String login, String password, User boss) {
        this.id = id;
        this.id1c = id1c;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.boss = boss;
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
}