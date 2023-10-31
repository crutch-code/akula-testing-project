package gcg.akula.service.views;

import gcg.akula.entity.dto.news.NewsDto;
import gcg.akula.entity.jpa.News;

public class NewsDtoFromNewsAdapter implements ViewerAdapter<NewsDto, News> {
    @Override
    public NewsDto convert(News entity) {
        return new NewsDto(
          entity.getId(),
          entity.getTitle(),
          entity.getContent(),
          entity.getAuthor().getId(),
          entity.getPublishDate()
        );
    }
}
