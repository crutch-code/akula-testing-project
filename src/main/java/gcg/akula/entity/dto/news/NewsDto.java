package gcg.akula.entity.dto.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import gcg.akula.entity.dto.BaseDto;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * DTO for {@link gcg.akula.entity.jpa.News}
 */

@JsonIncludeProperties
public class NewsDto extends BaseDto {

    @Size(max = 255)
    private String title;

    @Size(max = 255)
    private String content;

    private Long idAuthor;

    @PastOrPresent
    @JsonFormat( pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime publishDate;

    public NewsDto() {

    }

    public NewsDto(
            Long id,
            String title,
            String content,
            Long idAuthor,
            LocalDateTime publishDate
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.idAuthor = idAuthor;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }
}