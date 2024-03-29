package gcg.akula.service.handlers;


import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.exception.BadRequestException;
import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
@Primary
@Produces
public class BadRequestExceptionHandler implements ExceptionHandler<BadRequestException, HttpResponse<ApplicationResponse<?>>> {
    @Override
    public HttpResponse<ApplicationResponse<?>> handle(HttpRequest request, BadRequestException exception) {
        return HttpResponse.badRequest(
                ApplicationResponse.fail(
                        HttpStatus.BAD_REQUEST,
                        Map.of(
                                "message", exception.getMessage(),
                                "request", exception.getRequest()
                        ),
                        exception)
        );
    }
}
