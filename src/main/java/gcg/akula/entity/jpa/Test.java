package gcg.akula.entity.jpa;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "test")
@Serdeable
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_id_seq")
    @SequenceGenerator(name = "test_id_seq", sequenceName = "test_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "theme", nullable = false, length = Integer.MAX_VALUE)
    private String theme;

    @NotNull
    @Column(name = "min_ball", nullable = false)
    private Integer minBall;

    @OrderBy(value = "title ASC")
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tid")
    private Set<Question> questions = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lid")
    private Lesson lid;

    public Lesson getLid() {
        return lid;
    }

    public void setLid(Lesson lid) {
        this.lid = lid;
    }


    public Test(Long id, @NotNull String theme, @NotNull Integer minBall, Set<Question> questions) {
        this.id = id;
        this.theme = theme;
        this.minBall = minBall;
        this.questions = questions;
    }

    public Test() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getMinBall() {
        return minBall;
    }

    public void setMinBall(Integer minBall) {
        this.minBall = minBall;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}