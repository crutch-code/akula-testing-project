package gcg.akula.entity.dto.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.lesson.FlatLessonDto;
import gcg.akula.entity.jpa.Test;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FlatTestDto implements Serializable, DTO<Test> {

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

    @Override
    public Test toEntity() {
        return new Test(id, theme, minBall, null);
    }
}
