package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "theme", nullable = false, length = Integer.MAX_VALUE)
    private String theme;

    @NotNull
    @Column(name = "min_ball", nullable = false)
    private Integer minBall;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lid", nullable = false)
    private Lesson lid;

    public Test(Long id, @NotNull String theme, @NotNull Integer minBall, @NotNull Lesson lid) {
        this.id = id;
        this.theme = theme;
        this.minBall = minBall;
        this.lid = lid;
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

    public Lesson getLid() {
        return lid;
    }

    public void setLid(Lesson lid) {
        this.lid = lid;
    }
}