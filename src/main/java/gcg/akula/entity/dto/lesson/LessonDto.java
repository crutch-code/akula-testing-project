package gcg.akula.entity.dto.lesson;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.test.FlatTestDto;
import gcg.akula.entity.dto.test.TestDto;
import gcg.akula.entity.jpa.Lesson;
import io.micronaut.serde.annotation.Serdeable;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Serdeable
public class LessonDto extends FlatLessonDto{

    private String content;
    private String description;
    private List<FlatTestDto> tests;
    @Override
    public Lesson toEntity() {
        Lesson val = super.toEntity();
        val.setDisabled(disabled != null && disabled);
        val.setContent(content);
        val.setDescription(description);
        val.setTests(tests == null ? new HashSet<>() :
                tests.stream()
                        .map(FlatTestDto::toEntity)
                        .collect(Collectors.toSet())
        );
//        return new Lesson(
//                id, name, content, description, index,
//                tests == null ? new HashSet<>() : tests.stream().map(FlatTestDto::toEntity).collect(Collectors.toSet()),
//                disabled != null && disabled
//        );
        return val;
    }

    public LessonDto() {
    }



    public LessonDto(Lesson entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.description = entity.getDescription();
        this.index = entity.getIndex();
        this.tests = entity.getTests()
                .stream()
                .map(TestDto::new)
                .collect(Collectors.toList());
    }

    public String getContent() {
        return content;
    }

    public LessonDto setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LessonDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<FlatTestDto> getTests() {
        return tests;
    }

    public LessonDto setTests(List<FlatTestDto> tests) {
        this.tests = tests;
        return this;
    }
}
