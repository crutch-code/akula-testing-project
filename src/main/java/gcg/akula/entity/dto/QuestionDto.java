package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Question;
import io.micronaut.serde.annotation.Serdeable;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;

@Serdeable
public class QuestionDto implements Serializable, DTO<Question> {



    @Override
    public Question toEntity() {
        return null;
    }
}
