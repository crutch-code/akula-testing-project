package gcg.akula.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.jpa.News;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
public class NewsDto implements DTO<News> {
    private Long id;
    private String title;
    private String content;
    private UserDto author;
    private LocalDateTime publishDate;
    private StorageDto photo;

    @Override
    public News toEntity() {
        return new News(id, title, content, author.toEntity(), publishDate, photo.toEntity());
    }

    public NewsDto(Long id, String title, String content, UserDto author, LocalDateTime publishDate, StorageDto photo) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
        this.photo = photo;
    }

    public NewsDto(News news) {
        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        author = new UserDto(news.getAuthor());
        publishDate = news.getPublishDate();
        photo = new StorageDto(news.getPhoto(), true);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public StorageDto getPhoto() {
        return photo;
    }

    public void setPhoto(StorageDto photo) {
        this.photo = photo;
    }
}
