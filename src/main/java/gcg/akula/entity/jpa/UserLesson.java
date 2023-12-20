package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_lesson")
public class UserLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_lesson_id_seq")
    @SequenceGenerator(name = "user_lesson_id_seq", sequenceName = "user_lesson_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uid", nullable = false)
    private User uid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lid", nullable = false)
    private Lesson lid;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;

    public UserLesson(Long id, @NotNull User uid, @NotNull Lesson lid, @NotNull Integer status) {
        this.id = id;
        this.uid = uid;
        this.lid = lid;
        this.status = status;
    }

    public UserLesson() {

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

    public Lesson getLid() {
        return lid;
    }

    public void setLid(Lesson lid) {
        this.lid = lid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}