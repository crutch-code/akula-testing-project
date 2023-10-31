package gcg.akula.service;


import gcg.akula.entity.dto.news.NewsCreationDto;
import gcg.akula.entity.dto.news.NewsDto;
import gcg.akula.entity.jpa.News;
import gcg.akula.repository.NewsRepository;
import gcg.akula.service.views.NewsDtoFromNewsAdapter;
import gcg.akula.service.views.NewsFromCreationDtoAdapter;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Singleton
public class NewsService {

    @Inject
    NewsRepository newsRepository;

    public NewsDto saveNews(NewsCreationDto dto){
        return new NewsDtoFromNewsAdapter().convert(
                newsRepository.save(new NewsFromCreationDtoAdapter().convert(dto))
        );
    }

    public NewsDto getNewsById(Long id){
        return new NewsDtoFromNewsAdapter().convert(
                newsRepository.findById(id).orElseThrow(
                        ()-> new RuntimeException("No News with that identifier found")
                )
        );
    }
    public Page<NewsDto> getNews(
            String title,
            LocalDateTime start,
            LocalDateTime end,
            Long author,
            Pageable pageable
    ){
        return newsRepository
                .findByFilters(title, start, end,pageable)
                .map(new NewsDtoFromNewsAdapter()::convert);
    }

}
