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

@Singleton
@Primary
@Produces
public class BadRequestExceptionHandler implements ExceptionHandler<BadRequestException, HttpResponse<ApplicationResponse<String>>> {
    @Override
    public HttpResponse<ApplicationResponse<String>> handle(HttpRequest request, BadRequestException exception) {
        return HttpResponse.badRequest(
                ApplicationResponse.fail(
                        HttpStatus.BAD_REQUEST,
                        exception.getLocalizedMessage(),
                        exception)
        );
    }
}
