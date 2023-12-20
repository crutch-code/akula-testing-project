package gcg.akula.entity.dto;

import gcg.akula.entity.dto.lesson.FlatLessonDto;
import gcg.akula.entity.jpa.Course;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Serdeable
public class CourseDto implements DTO<Course>{


    Long id;

    String name;

    List<FlatLessonDto> lessons;

    @Override
    public Course toEntity() {
        return new Course(
                id, name,
                lessons == null ? new ArrayList<>() : lessons.stream().map(FlatLessonDto::toEntity).collect(Collectors.toList())
        );
    }

    public CourseDto() {
    }

    public CourseDto(Long id, String name, List<FlatLessonDto> lessons) {
        this.id = id;
        this.name = name;
        this.lessons = lessons;
    }

    public CourseDto(Course entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.lessons = entity.getLessons()
                .stream()
                .map(
                        m -> new FlatLessonDto(m.getId(), m.getName(), m.getIndex(), null)
                ).collect(Collectors.toList());
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

    public List<FlatLessonDto> getLessons() {
        return lessons;
    }

    public void setLessons(List<FlatLessonDto> lessons) {
        this.lessons = lessons;
    }
}
