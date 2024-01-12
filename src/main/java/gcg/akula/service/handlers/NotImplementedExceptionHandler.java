package gcg.akula.service.handlers;

import gcg.akula.entity.response.ApplicationResponse;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import org.apache.commons.lang3.NotImplementedException;

@Primary
@Produces
@Singleton
public class NotImplementedExceptionHandler implements ExceptionHandler<NotImplementedException, HttpResponse<ApplicationResponse<?>>> {
    @Override
    public HttpResponse<ApplicationResponse<?>> handle(HttpRequest request, NotImplementedException exception) {
        return HttpResponse.notFound(
                ApplicationResponse.fail(
                        HttpStatus.NOT_IMPLEMENTED,
                        exception.getMessage(),
                        exception)
        );
    }
}
