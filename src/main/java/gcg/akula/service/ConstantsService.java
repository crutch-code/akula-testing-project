package gcg.akula.service;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

@Singleton
public class ConstantsService {
    /*
    * Участок конфигурируемых переменных
    * */
    @Value("${micronaut.application.default-page-size}")
    public Integer DEFAULT_PAGE_SIZE;
    /*
    * Конец участка
    * */

}
