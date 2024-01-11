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

    private Boolean disabled = false;


    public FlatLessonDto() {
    }

    public FlatLessonDto(Lesson entity) {
        this.id = entity.getId();
        this.index = entity.getIndex();
        this.name = entity.getName();
        this.completed = null;
        this.disabled = entity.getDisabled();
    }

    public FlatLessonDto(Long id, String name, Integer index, Boolean completed, Boolean disabled) {
        this.id = id;
        this.name = name;
        this.index = index;
        this.completed = completed;
        this.disabled = disabled;
    }

    public Long getId() {
        return id;
    }

    public FlatLessonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FlatLessonDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getIndex() {
        return index;
    }

    public FlatLessonDto setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public FlatLessonDto setCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    @Override
    public Lesson toEntity() {
        return new Lesson(id, name, null, null , index, null, disabled);
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public FlatLessonDto setDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }
}