package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq")
    @SequenceGenerator(name = "question_id_seq", sequenceName = "question_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @NotNull
    @Column(name = "type", nullable = false)
    private Integer type;

    @NotNull
    @Column(name = "points", nullable = false)
    private Integer points;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tid", nullable = false)
    private Test tid;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "qid")
    private Set<Answer> answers = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "qid")
    private Set<Comparison> comparisons = new LinkedHashSet<>();



    public Question(Long id, @NotNull String title, @NotNull Integer type, @NotNull Integer points) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.points = points;
    }

    public Question() {

    }


    public Set<Comparison> getComparisons() {
        return comparisons;
    }

    public void setComparisons(Set<Comparison> comparisons) {
        this.comparisons = comparisons;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Test getTid() {
        return tid;
    }

    public void setTid(Test tid) {
        this.tid = tid;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}