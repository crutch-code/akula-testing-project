package gcg.akula.service.response.handlers;

import gcg.akula.entity.response.ApplicationResponse;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Primary
@Produces
public class RuntimeExceptionHandler implements ExceptionHandler<RuntimeException, HttpResponse<ApplicationResponse<String>>> {
    @Override
    public HttpResponse<ApplicationResponse<String>> handle(HttpRequest request, RuntimeException exception) {
        return HttpResponse.serverError(ApplicationResponse.fail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getLocalizedMessage(),
                exception)
        );
    }
}
