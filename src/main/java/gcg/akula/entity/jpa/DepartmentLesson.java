package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department_lesson")
public class DepartmentLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_lesson_id_seq")
    @SequenceGenerator(name = "department_lesson_id_seq", sequenceName = "department_lesson_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "did", nullable = false)
    private Department did;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lid", nullable = false)
    private Lesson lid;

    public DepartmentLesson() {
    }

    public DepartmentLesson(Long id, @NotNull Department did, @NotNull Lesson lid) {
        this.id = id;
        this.did = did;
        this.lid = lid;
    }

    public Long getId() {
        return id;
    }

    public DepartmentLesson setId(Long id) {
        this.id = id;
        return this;
    }

    public Department getDid() {
        return did;
    }

    public DepartmentLesson setDid(Department did) {
        this.did = did;
        return this;
    }

    public Lesson getLid() {
        return lid;
    }

    public DepartmentLesson setLid(Lesson lid) {
        this.lid = lid;
        return this;
    }
}