package gcg.akula.entity.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public interface DTO<E> {
    E toEntity();
}
