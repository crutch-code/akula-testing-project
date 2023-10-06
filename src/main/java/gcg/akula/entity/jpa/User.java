package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Getter
@Setter
@Comment("Пользователь")
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

}