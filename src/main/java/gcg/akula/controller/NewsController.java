package gcg.akula.controller;

import gcg.akula.entity.dto.NewsDto;
import gcg.akula.entity.jpa.News;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.NewsService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller("/api/news")
public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Inject
    NewsService newsService;

    @Get("/")
    public ApplicationResponse<Page<NewsDto>> getNews(
            Pageable pageable
    ) {
        try {
            return ApplicationResponse.ok(
                    newsService.getNews(
                            pageable
                    )
            );
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Post(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<NewsDto> publishNews(@Body NewsDto body) {
        try {
            return ApplicationResponse.ok(
                    newsService.publish(body)
            );

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> deleteNews(
            long id
    ) {
        newsService.delete(id);
        return ApplicationResponse.ok("Новость удалена");
    }

    @Get(value = "/{id}")
    public ApplicationResponse<NewsDto> getNewsById(long id) {
        Optional<NewsDto> news = newsService.getNewsById(id);
        return news
                .map(ApplicationResponse::ok)
                .orElseGet(() -> ApplicationResponse.fail(HttpStatus.NOT_FOUND, new ObjectNotFoundException(News.class.getName(), id)));
    }

    @Put(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<NewsDto> updateNews(
            @Body NewsDto update
    ) {
        try {
            return ApplicationResponse.ok(newsService.update(update));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
