package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Comparison;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link gcg.akula.entity.jpa.Comparison}
 */

@Serdeable
public class ComparisonDto implements DTO<Comparison> {
    private  Long id;

    private OptionDto lid;

    private OptionDto rid;

    public ComparisonDto() {
    }

    public ComparisonDto(Comparison entity) {
        this.id = entity.getId();
        this.lid = new OptionDto(entity.getLid());
        this.rid = new OptionDto(entity.getRid());
    }

    public ComparisonDto(Long id, OptionDto lid, OptionDto rid) {
        this.id = id;
        this.lid = lid;
        this.rid = rid;
    }

    @Override
    public Comparison toEntity() {
        return new Comparison(
                id,
                lid.toEntity(),
                rid.toEntity()
        );
    }

    public Long getId() {
        return id;
    }

    public ComparisonDto setId(Long id) {
        this.id = id;
        return this;
    }

    public OptionDto getLid() {
        return lid;
    }

    public ComparisonDto setLid(OptionDto lid) {
        this.lid = lid;
        return this;
    }

    public OptionDto getRid() {
        return rid;
    }

    public ComparisonDto setRid(OptionDto rid) {
        this.rid = rid;
        return this;
    }
}