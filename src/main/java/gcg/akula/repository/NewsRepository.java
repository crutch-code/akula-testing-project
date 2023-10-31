package gcg.akula.repository;

import gcg.akula.entity.jpa.News;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;
import jakarta.annotation.Nullable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDateTime;

@Repository
public abstract class NewsRepository implements PageableRepository<News, Long> {

    @PersistenceContext
    EntityManager manager;


    @Query(
            value = "from News as t where " +
                    "t.title like concat('%', :name,'%') and " +
                    "t.publishDate >= :startDate and " +
                    "t.publishDate <= :endDate ",
            countQuery = "select count(t) from News as t where " +
                    "t.title like concat('%', :name,'%') and " +
                    "t.publishDate >= :startDate and " +
                    "t.publishDate <= :endDate "
    )
    public abstract Page<News> findByFilters(
            @Nullable String name,
            @Nullable LocalDateTime startDate,
            @Nullable LocalDateTime endDate,
            @Nullable Pageable pageable
    );

//    public Page<News> func(
//            @Nullable String name,
//            @Nullable LocalDateTime startDate,
//            @Nullable LocalDateTime endDate,
//            @Nullable Long author,
//            @Nullable Pageable pageable
//    ){
//        Query q = manager.createQuery("");
//    }
}
