package gcg.akula.controller;


import gcg.akula.entity.dto.news.NewsCreationDto;
import gcg.akula.entity.dto.news.NewsDto;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.NewsService;
import io.micronaut.data.model.Page;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller("/api/news/")
public class NewsController extends BaseController{

    @Inject
    NewsService newsService;

    @ExecuteOn(TaskExecutors.IO)
    @Get("get{?}")
    public Page<NewsDto> getNews(
            @QueryValue Optional<Long> id,
            @QueryValue Optional<String> title,
            @QueryValue(value = "author_id") Optional<Long> authorId,
            @QueryValue(value = "start_date") Optional<LocalDateTime> startDate,
            @QueryValue(value = "end_date") Optional<LocalDateTime> endDate,
            @QueryValue(value = "page_num") Optional<Integer> pageNum,
            @QueryValue(value = "page_size") Optional<Integer> pageSize
    ){
//        if(id.isPresent()){
//            return  newsService.getNewsById(id.get());
//        }
        return newsService.getNews(
                title.orElse(""),
                startDate.orElse(LocalDateTime.of(1999, 1,1,0,0,0)),
                endDate.orElse(LocalDateTime.now()),
                authorId.orElse(null),
                utils.getPageable(pageNum.orElse(null), pageSize.orElse(null))
        );
    }

    @ExecuteOn(TaskExecutors.IO)
    @Post("publish")
    public HttpResponse<ApplicationResponse> publishNews(
            @Body NewsCreationDto body
    ){
        newsService.saveNews(body);
        return response.addingSuccess("");
    }



}
