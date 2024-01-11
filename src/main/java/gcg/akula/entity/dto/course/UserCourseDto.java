package gcg.akula.entity.dto.course;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.UserDto;
import gcg.akula.entity.jpa.UserCourse;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class UserCourseDto implements DTO<UserCourse> {

    private Long id;

    private UserDto user;

    private CourseDto courseDto;

    public UserCourseDto(UserCourse entity) {
        this.id = entity.getId();
        this.user = new UserDto(entity.getUid());
        this.courseDto = new CourseDto(entity.getCid());
    }

    public UserCourseDto(Long id, UserDto user, CourseDto courseDto) {
        this.id = id;
        this.user = user;
        this.courseDto = courseDto;
    }

    public Long getId() {
        return id;
    }

    public UserCourseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public UserCourseDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public UserCourseDto setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
        return this;
    }

    @Override
    public UserCourse toEntity() {
        return null;
    }
}
