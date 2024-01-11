package gcg.akula.entity.dto.question;

import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.jpa.Test;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class FlatQuestionDto implements DTO<Test> {

    private Long id;

    @Override
    public Test toEntity() {
        return null;
    }
}
