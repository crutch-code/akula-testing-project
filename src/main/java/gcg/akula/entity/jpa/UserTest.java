package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_test")
public class UserTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_test_id_seq")
    @SequenceGenerator(name = "user_test_id_seq", sequenceName = "user_test_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uid", nullable = false)
    private User uid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tid", nullable = false)
    private Test tid;

    @NotNull
    @Column(name = "points", nullable = false)
    private Integer points;

    public UserTest(Long id, @NotNull User uid, @NotNull Test tid, @NotNull Integer points) {
        this.id = id;
        this.uid = uid;
        this.tid = tid;
        this.points = points;
    }

    public UserTest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public Test getTid() {
        return tid;
    }

    public void setTid(Test tid) {
        this.tid = tid;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}