package gcg.akula.entity.dto.course;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.lesson.FlatLessonDto;
import gcg.akula.entity.jpa.Course;
import io.micronaut.serde.annotation.Serdeable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Serdeable
public class CourseDto implements DTO<Course> {


    private Long id;

    private String name;

    private List<FlatLessonDto> lessons;

    private Boolean disabled = false;
    @Override
    public Course toEntity() {
        return new Course(
                id,
                name,
                lessons == null ? new ArrayList<>() :
                        lessons.stream()
                                .map(FlatLessonDto::toEntity)
                                .collect(Collectors.toList()),
                disabled
        );
    }

    public CourseDto() {
    }

    public CourseDto(Long id, String name, List<FlatLessonDto> lessons, Boolean disabled) {
        this.id = id;
        this.name = name;
        this.lessons = lessons;
        this.disabled = disabled;
    }

    public CourseDto(Course entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.lessons = entity.getLessons()
                .stream()
                .map(
                        m -> new FlatLessonDto(m.getId(), m.getName(), m.getIndex(), null, m.getDisabled())
                ).collect(Collectors.toList());
        this.disabled = entity.getDisabled();
    }

    public Long getId() {
        return id;
    }

    public CourseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<FlatLessonDto> getLessons() {
        return lessons;
    }

    public CourseDto setLessons(List<FlatLessonDto> lessons) {
        this.lessons = lessons;
        return this;
    }
}
