package gcg.akula.service.views;

import gcg.akula.entity.dto.news.NewsCreationDto;
import gcg.akula.entity.jpa.News;
import gcg.akula.entity.jpa.User;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class NewsFromCreationDtoAdapter implements ViewerAdapter<News, NewsCreationDto> {
    @Override
    public News convert(NewsCreationDto entity) {
        User author = new User();
        author.setId(entity.getAuthorId());

        return new News(
                null,
                entity.getTitle(),
                entity.getContent(),
                author,
                entity.getPublishDate() == null ? LocalDateTime.now(ZoneId.systemDefault()) : entity.getPublishDate()
        );
    }
}
