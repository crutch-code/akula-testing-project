package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Answer;
import gcg.akula.entity.jpa.Comparison;
import gcg.akula.entity.jpa.Question;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Serdeable
public class QuestionDto implements Serializable, DTO<Question> {


    private Long id;

    private String title;

    private Integer type;

    private Integer points;

    private List<AnswerDto> answers;

    private  List<ComparisonDto> comparisons;

    public QuestionDto(Question entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.type = entity.getType();
        this.points = entity.getPoints();
        this.answers = entity.getAnswers()== null ? new ArrayList<>() :
                entity.getAnswers()
                        .stream()
                        .map(AnswerDto::new)
                        .collect(Collectors.toList());
        this.comparisons = entity.getComparisons() == null ? new ArrayList<>() :
                entity.getComparisons()
                        .stream()
                        .map(ComparisonDto::new)
                        .collect(Collectors.toList());
    }

    @Override
    public Question toEntity() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public QuestionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public QuestionDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public QuestionDto setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getPoints() {
        return points;
    }

    public QuestionDto setPoints(Integer points) {
        this.points = points;
        return this;
    }
}
