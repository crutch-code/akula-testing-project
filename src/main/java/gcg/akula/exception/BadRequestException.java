package gcg.akula.exception;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class BadRequestException extends RuntimeException{

    private final Object request;

    public BadRequestException(String message, Object request) {
        super(message);
        this.request = request;
    }

    public BadRequestException(Object request) {
        this.request = request;
    }

    public Object getRequest() {
        return request;
    }
}
