package gcg.akula.entity.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ApplicationResponseWithId extends ApplicationResponse{
    private Long id;

    public ApplicationResponseWithId(Integer httpCode, String message, String endpoint, Long id) {
        super(httpCode, message, endpoint);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
