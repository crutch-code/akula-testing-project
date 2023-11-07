package gcg.akula.controller;

import gcg.akula.entity.dto.NewsDto;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.NewsService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/api/news")
public class NewsController {

    @Inject
    NewsService newsService;

    @Get("/")
    public ApplicationResponse<Page<NewsDto>> getNews(Pageable pageable) {
        return ApplicationResponse.ok(newsService.getNews(pageable));
    }

    @Post("/")
    public ApplicationResponse publishNews(@Body NewsDto body) {
        return ApplicationResponse.ok(newsService.publish(body));
    }
}
