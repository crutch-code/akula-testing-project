package gcg.akula.entity.response.exceptions;

import gcg.akula.entity.response.ApplicationResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseApplicationExceptionResponse extends RuntimeException {

    private ApplicationResponse response;



}
