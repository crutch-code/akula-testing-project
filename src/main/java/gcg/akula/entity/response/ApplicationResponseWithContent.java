package gcg.akula.entity.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public final class ApplicationResponseWithContent extends ApplicationResponse{


    @JsonInclude
    private Object content;

    public ApplicationResponseWithContent() {
    }

    public ApplicationResponseWithContent(
             Integer httpCode,
             String message,
             String endpoint,
             Object content) {
        super(httpCode, message, endpoint);
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
