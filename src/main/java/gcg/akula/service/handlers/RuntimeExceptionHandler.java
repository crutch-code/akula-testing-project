package gcg.akula.service.handlers;

import gcg.akula.entity.response.ApplicationResponse;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Primary
@Produces
public class RuntimeExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse<ApplicationResponse<String>>> {

    private static final Logger logger = LoggerFactory.getLogger(RuntimeExceptionHandler.class);

    @Override
    public HttpResponse<ApplicationResponse<String>> handle(HttpRequest request, RuntimeException exception) {
        logger.error(exception.getMessage(), exception);
        return HttpResponse.serverError(ApplicationResponse.fail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                exception)
        );
    }
}
