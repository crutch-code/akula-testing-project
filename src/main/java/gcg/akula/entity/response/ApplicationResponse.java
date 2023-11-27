package gcg.akula.entity.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.serde.annotation.Serdeable;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Optional;

@Serdeable
@JsonPropertyOrder(
        {"status", "body", "reason"}
)
public class ApplicationResponse<T> {
    private HttpStatus status;
    private T body;
    private Throwable reason;

    public ApplicationResponse(HttpStatus status, T body, Throwable reason) {
        this.status = status;
        this.body = body;
        this.reason = reason;
    }

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
        if (reason == null) {
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

    public static <B> ApplicationResponse<B> fail(Throwable reason) {
        return new ApplicationResponse(HttpStatus.BAD_REQUEST, reason);
    }

    public static <B> ApplicationResponse<B> fail(HttpStatus status, Throwable reason) {
        return new ApplicationResponse(status, reason);
    }

    public static <B> ApplicationResponse<B> fail(HttpStatus status, B body, Throwable reason) {
        return new ApplicationResponse(status, body, reason);
    }
}
