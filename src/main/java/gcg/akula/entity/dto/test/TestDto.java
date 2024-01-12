package gcg.akula.entity.dto.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.QuestionDto;
import gcg.akula.entity.dto.TeachDto;
import gcg.akula.entity.jpa.Question;
import gcg.akula.entity.jpa.Test;
import io.micronaut.serde.annotation.Serdeable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for {@link gcg.akula.entity.jpa.Test}
 */

@Serdeable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public final class TestDto extends FlatTestDto {

    private List<QuestionDto> questions;

    public TestDto() {

    }

    public TestDto(Test entity) {
        super(entity);
        this.questions = entity.getQuestions() == null ? new ArrayList<>() :
                entity.getQuestions()
                        .stream()
                        .map(QuestionDto::new)
                        .collect(Collectors.toList());
    }

    public TestDto(Long id, String theme, Integer minBall, List<QuestionDto> questions) {
        super(id, theme, minBall);
        this.questions = questions;
    }

    @Override
    public Test toEntity() {
        Test val = super.toEntity();
        if(this.questions != null)
            val.setQuestions(questions.stream().map(QuestionDto::toEntity).collect(Collectors.toSet()));
        return val;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public TestDto setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
        return this;
    }
}