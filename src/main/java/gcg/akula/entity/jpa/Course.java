package gcg.akula.entity.jpa;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Serdeable
@Entity
@Table(name = "course", schema = "public")
public class Course {
    @Id
    @SequenceGenerator(name = "course_id_seq", sequenceName = "public.course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_seq")
    private Long id;
    private String name;
    @OrderBy("index ASC")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<>();


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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
