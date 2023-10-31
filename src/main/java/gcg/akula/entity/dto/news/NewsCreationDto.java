package gcg.akula.entity.dto.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.dto.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NewsCreationDto {

    @NotNull
    @Size(max = 255)
    private final String title;

    @NotNull
    @Size(max = 255)
    private final String content;

    @NotNull
    private final Long authorId;

    @PastOrPresent
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private final LocalDateTime publishDate;

    public NewsCreationDto(@NotNull String title, @NotNull String content, @NotNull Long authorId, LocalDateTime publishDate) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }
}
