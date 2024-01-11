package gcg.akula.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JoinFormula;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_id_seq")
    @SequenceGenerator(name = "lesson_id_seq", sequenceName = "lesson_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "index", nullable = false)
    private Integer index;

    @OneToMany(mappedBy = "lid")
    private Set<Test> tests = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Course cid;

    @NotNull
    @Column(name = "disabled", nullable = false)
    private Boolean disabled = false;


    public Course getCid() {
        return cid;
    }

    public void setCid(Course cid) {
        this.cid = cid;
    }


    public Lesson(Long id, String name, String content, String description, Integer index, Set<Test> tests, Course cid, @NotNull Boolean disabled) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.description = description;
        this.index = index;
        this.tests = tests;
        this.cid = cid;
        this.disabled = disabled;
    }


    public Lesson(Long id, String name, String content, String description, Integer index, Set<Test> tests, @NotNull Boolean disabled) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.description = description;
        this.index = index;
        this.tests = tests;
        this.disabled = disabled;
    }

    public Lesson() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

}