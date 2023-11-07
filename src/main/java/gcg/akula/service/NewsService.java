package gcg.akula.service;

import gcg.akula.entity.dto.NewsDto;
import gcg.akula.repository.NewsRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class NewsService {
    @Inject
    NewsRepository newsRepository;

    public Page<NewsDto> getNews(Pageable pageable) {
        return newsRepository
                .findAll(pageable)
                .map(NewsDto::new);
    }

    public NewsDto publish(NewsDto news) {
        return new NewsDto(newsRepository.save(news.toEntity()));
    }
}
