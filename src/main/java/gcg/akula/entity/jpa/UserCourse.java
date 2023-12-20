package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_course")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_course_id_seq")
    @SequenceGenerator(name = "user_course_id_seq", sequenceName = "user_course_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uid", nullable = false)
    private User uid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cid", nullable = false)
    private Course cid;

    public UserCourse(Long id, @NotNull User uid, @NotNull Course cid) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
    }

    public UserCourse() {

    }

    public Long getId() {
        return id;
    }
}