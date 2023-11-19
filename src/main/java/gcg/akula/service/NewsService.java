package gcg.akula.service;

import gcg.akula.entity.dto.NewsDto;
import gcg.akula.repository.NewsRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Singleton
public class NewsService {

    @Inject
    NewsRepository newsRepository;


    public Page<NewsDto> getNews(Pageable pageable) {
        return newsRepository
                .findAll(pageable)
                .map(NewsDto::new);
    }

    public Optional<NewsDto> getNewsById(long id) {
        return newsRepository
                .findById(id)
                .map(NewsDto::new);
    }

    public NewsDto publish(NewsDto news) {
        news.setPublishDate(LocalDateTime.now(ZoneId.systemDefault()));
        return new NewsDto(
                newsRepository.save(news.toEntity())
        );
    }

    public void delete(Long id){
        newsRepository.deleteById(id);
    }

    public NewsDto update(NewsDto update){
        return new NewsDto(
                newsRepository.update(update.toEntity())
        );
    }
}
