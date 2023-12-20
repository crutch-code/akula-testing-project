package gcg.akula.entity.dto.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gcg.akula.entity.dto.DTO;
import gcg.akula.entity.dto.TeachDto;
import gcg.akula.entity.jpa.Test;
import io.micronaut.serde.annotation.Serdeable;

/**
 * DTO for {@link gcg.akula.entity.jpa.Test}
 */

@Serdeable
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class TestDto extends FlatTestDto {



    public TestDto(Test entity) {
        this.id = entity.getId();
        this.theme = entity.getTheme();
        this.minBall = entity.getMinBall();
    }

    public TestDto(Long id, String theme, Integer minBall) {
        this.id = id;
        this.theme = theme;
        this.minBall = minBall;
    }

    @Override
    public Test toEntity() {
        return null;
    }


}