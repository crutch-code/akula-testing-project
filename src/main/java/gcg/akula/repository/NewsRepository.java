package gcg.akula.repository;

import gcg.akula.entity.jpa.News;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public abstract class NewsRepository implements PageableRepository<News, Long> {

}
