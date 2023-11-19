package gcg.akula.controller;

import gcg.akula.entity.dto.NewsDto;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.NewsService;
import io.micronaut.context.annotation.Value;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
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
    ){
        try{
            return ApplicationResponse.ok(
                    newsService.getNews(
                            pageable
                    )
            );
        }catch (Exception ex){
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

        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Delete(value = "/{id}")
    public ApplicationResponse<String> deleteNews(
             long id
    ){
        newsService.delete(id);
        return ApplicationResponse.ok("Новость удалена");
    }

    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse<NewsDto> updateNews(
            @Body NewsDto update
    ){
        try {
            return ApplicationResponse.ok(newsService.update(update));
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
