package gcg.akula.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

@Serdeable
@Entity
@Table(name = "lesson", schema = "public")
public class Lesson {
    @Id
    @SequenceGenerator(name = "lesson_id_seq", sequenceName = "public.lesson_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_id_seq")
    private Long id;
    private String name;
    private String content;
    private String description;
    private int index;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cid", nullable=false)
    private Course course;


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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
