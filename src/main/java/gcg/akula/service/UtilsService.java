package gcg.akula.service;

import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.lang.reflect.Field;

@Singleton
public class UtilsService {

    @Inject
    ConstantsService constantsService;

    public Pageable getPageable(Integer pageNum, Integer pageSize) {
        return Pageable.from((pageNum != null) ? pageNum : 0, (pageSize != null) ? pageSize : constantsService.DEFAULT_PAGE_SIZE);
    }

    public <T> T updateEntity(T entity, T update) throws IllegalAccessException {
        for (Field field : update.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(update) != null) {
                field.set(entity, field.get(update));
            }
        }
        return entity;
    }
}
