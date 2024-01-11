package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Option;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link gcg.akula.entity.jpa.Option}
 */
@Serdeable
public class OptionDto implements DTO<Option> {

    private Long id;

    private String content;

    private Boolean isLeft;

    public OptionDto() {
    }

    public OptionDto(Option entity) {
        this.id = entity.getId();
        this.isLeft = entity.getLeft();
        this.content = entity.getContent();
    }

    public OptionDto(Long id, String content, Boolean isLeft) {
        this.id = id;
        this.content = content;
        this.isLeft = isLeft;
    }

    @Override
    public Option toEntity() {
        return new Option(id, content, isLeft);
    }
    public Long getId() {
        return id;
    }

    public OptionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public OptionDto setContent(String content) {
        this.content = content;
        return this;
    }

    public Boolean getLeft() {
        return isLeft;
    }

    public OptionDto setLeft(Boolean left) {
        isLeft = left;
        return this;
    }
}