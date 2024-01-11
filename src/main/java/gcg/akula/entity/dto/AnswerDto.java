package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Answer;

/**
 * DTO for {@link gcg.akula.entity.jpa.Answer}
 */
public class AnswerDto implements DTO<Answer> {
    private Long id;
    private String content;
    private Boolean correct;

    public AnswerDto(Answer entity) {
    }

    public AnswerDto(Long id, String content, Boolean correct) {
        this.id = id;
        this.content = content;
        this.correct = correct;
    }

    @Override
    public Answer toEntity() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public AnswerDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public AnswerDto setContent(String content) {
        this.content = content;
        return this;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public AnswerDto setCorrect(Boolean correct) {
        this.correct = correct;
        return this;
    }
}