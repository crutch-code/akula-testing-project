package gcg.akula.entity.dto.lesson;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.UserDto;
import gcg.akula.entity.jpa.UserLesson;
import io.micronaut.serde.annotation.Serdeable;

/**
 * DTO for {@link gcg.akula.entity.jpa.UserLesson}
 */

@Serdeable
public class UserLessonDto implements DTO<UserLesson> {
    private Long id;

    private UserDto user;

    private FlatLessonDto lesson;

    private Integer status;

    public UserLessonDto() {
    }

    public UserLessonDto(Long id, UserDto user, FlatLessonDto lesson, Integer status) {
        this.id = id;
        this.user = user;
        this.lesson = lesson;
        this.status = status;
    }

    public UserLessonDto(UserLesson entity) {
        this.id = entity.getId();
        this.user = new UserDto(entity.getUid());
        this.lesson = new FlatLessonDto(entity.getLid());
        this.status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public UserLessonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public UserDto getUser() {
        return user;
    }

    public UserLessonDto setUser(UserDto user) {
        this.user = user;
        return this;
    }

    public FlatLessonDto getLesson() {
        return lesson;
    }

    public UserLessonDto setLesson(FlatLessonDto lesson) {
        this.lesson = lesson;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public UserLessonDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    public UserLesson toEntity() {
        return new UserLesson(id, user.toEntity(), lesson.toEntity(), status);
    }
}