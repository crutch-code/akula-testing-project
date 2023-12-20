package gcg.akula.entity.dto.lesson;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.jpa.Lesson;
import gcg.akula.entity.jpa.Test;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link gcg.akula.entity.jpa.Lesson}
 */
@Serdeable
public class FlatLessonDto implements Serializable, DTO <Lesson> {

    protected Long id;

    protected String name;
    protected Integer index;

    protected Boolean completed = false;

    public FlatLessonDto() {
    }

    public FlatLessonDto(Long id, String name, Integer index, Boolean completed) {
        this.id = id;
        this.name = name;
        this.index = index;
        this.completed = completed;
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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public Lesson toEntity() {
        return new Lesson(id, name, null, null , index, null);
    }
}