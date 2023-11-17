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

    @Value("${micronaut.data.pageable.default-page-size}")
    public Integer DEFAULT_PAGE_SIZE;

    @Value("${micronaut.data.pageable.max-page-size}")
    public Integer MAX_PAGE_SIZE;

    @Inject
    NewsService newsService;

    @Get("/")
    public ApplicationResponse<Page<NewsDto>> getNews(
            @QueryValue Optional<Integer> page,
            @QueryValue Optional<Integer> size
            ) {
        try{
            return ApplicationResponse.ok(
                    newsService.getNews(
                            Pageable.from(
                                    page.orElse(0),
                                    size.orElse(DEFAULT_PAGE_SIZE)
                            )
                    )
            );
        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Post(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse publishNews(@Body NewsDto body) {
        try {
            return ApplicationResponse.ok(
                    newsService.publish(body)
            );

        }catch (Exception ex){
            logger.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Delete(value = "/")
    public ApplicationResponse deleteNews(
            @QueryValue Optional<Long> id
    ){
        newsService.delete(id.orElseThrow(() -> new RuntimeException("Не передан идентификатор")));
        return ApplicationResponse.ok("Новость с id: " + id.get() + "- удалена");
    }

    @Patch(value = "/", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ApplicationResponse updateNews(
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
