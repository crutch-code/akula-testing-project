package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.News;
import gcg.akula.entity.jpa.User;
import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
public class NewsDto implements DTO<News> {
    private Long id;
    private String title;
    private String content;
    private User author;
    private LocalDateTime publishDate;

    @Override
    public News toEntity() {
        return new News(id, title, content, author, publishDate);
    }

    public NewsDto(News news) {
        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        author = news.getAuthor();
        publishDate = news.getPublishDate();
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }
}
