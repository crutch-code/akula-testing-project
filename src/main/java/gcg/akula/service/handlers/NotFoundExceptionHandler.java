package gcg.akula.service.handlers;

import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.BadRequestException;
import gcg.akula.exception.NotFoundException;
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
public class NotFoundExceptionHandler implements ExceptionHandler<NotFoundException, HttpResponse<ApplicationResponse<?>>> {
    @Override
    public HttpResponse<ApplicationResponse<?>> handle(HttpRequest request, NotFoundException exception) {
        return HttpResponse.notFound(
                ApplicationResponse.fail(
                        HttpStatus.NOT_FOUND,
                        exception.getLocalizedMessage(),
                        exception)
        );
    }
}
