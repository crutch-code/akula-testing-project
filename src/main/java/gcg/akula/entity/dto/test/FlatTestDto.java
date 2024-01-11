package gcg.akula.entity.dto.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.lesson.FlatLessonDto;
import gcg.akula.entity.jpa.Test;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlatTestDto implements DTO<Test> {

    protected Long id;
    protected String theme;
    protected Integer minBall;

    public FlatTestDto() {
    }

    public FlatTestDto(Test entity){
        this.id = entity.getId();
        this.theme = entity.getTheme();
        this.minBall = entity.getMinBall();
    }
    public FlatTestDto(Long id, String theme, Integer minBall) {
        this.id = id;
        this.theme = theme;
        this.minBall = minBall;
    }

    public Long getId() {
        return id;
    }

    public FlatTestDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTheme() {
        return theme;
    }

    public FlatTestDto setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public Integer getMinBall() {
        return minBall;
    }

    public FlatTestDto setMinBall(Integer minBall) {
        this.minBall = minBall;
        return this;
    }

    @Override
    public Test toEntity() {
        return new Test(id, theme, minBall, null);
    }
}
