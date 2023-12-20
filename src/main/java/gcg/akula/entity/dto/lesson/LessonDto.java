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

    String content;
    String description;
    List<FlatTestDto> tests;

    @Override
    public Lesson toEntity() {
        return new Lesson(
                id, name, content, description, index,
                tests == null ? new HashSet<>() : tests.stream().map(FlatTestDto::toEntity).collect(Collectors.toSet())
        );
    }

    public LessonDto() {
    }


    public LessonDto(
            Long id, String name, Integer index, Boolean completed,
            String content, String description, List<FlatTestDto> tests
    ) {
        super(id, name, index, completed);
        this.content = content;
        this.description = description;
        this.tests = tests;
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FlatTestDto> getTests() {
        return tests;
    }

    public void setTests(List<FlatTestDto> tests) {
        this.tests = tests;
    }
}
