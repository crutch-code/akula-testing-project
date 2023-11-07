package gcg.akula.entity.response;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.serde.annotation.Serdeable;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Optional;

@Serdeable
public class ApplicationResponse<T> {
    private HttpStatus status;
    private T body;
    private Throwable reason;

    public ApplicationResponse(HttpStatus status, T body) {
        this.status = status;
        this.body = body;
    }

    public ApplicationResponse(HttpStatus status, Throwable reason) {
        this.status = status;
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getReason() {
        if(reason == null) {
            return null;
        }
        return ExceptionUtils.getStackTrace(reason);
    }

    public @NonNull Optional<T> getBody() {
        return Optional.ofNullable(body);
    }


    public static <B> ApplicationResponse<B> ok(B body) {
        return new ApplicationResponse(HttpStatus.OK, body);
    }

    public static ApplicationResponse<String> fail(Throwable reason) {
        return new ApplicationResponse(HttpStatus.BAD_REQUEST, reason);
    }

    public static ApplicationResponse<String> fail(HttpStatus status, Throwable reason) {
        return new ApplicationResponse(status, reason);
    }
}
