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
    private Boolean disabled = false;


    @Override
    public News toEntity() {
        return new News(id, title, content, author.toEntity(), publishDate, photo.toEntity(), disabled);
    }

    public NewsDto(Long id, String title, String content, UserDto author, LocalDateTime publishDate, StorageDto photo, Boolean disabled) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
        this.photo = photo;
        this.disabled = disabled;
    }

    public NewsDto(News news) {
        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        author = new UserDto(news.getAuthor());
        publishDate = news.getPublishDate();
        photo = new StorageDto(news.getPhoto(), true);
        disabled = news.getDisabled();
    }


    public Long getId() {
        return id;
    }

    public NewsDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NewsDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewsDto setContent(String content) {
        this.content = content;
        return this;
    }

    public UserDto getAuthor() {
        return author;
    }

    public NewsDto setAuthor(UserDto author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public NewsDto setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
        return this;
    }

    public StorageDto getPhoto() {
        return photo;
    }

    public NewsDto setPhoto(StorageDto photo) {
        this.photo = photo;
        return this;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public NewsDto setDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }
}
