package gcg.akula.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gcg.akula.entity.jpa.Teach;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class TeachDto {
    private Long id;
    private String name;
    private int type;
    private String target;


    public TeachDto(Teach teach) {
        this.id = teach.getId();
        this.name = teach.getName();
        this.type = teach.getType();
        this.target = teach.getTarget();
    }

    public Long getId() {
        return id;
    }

    public TeachDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeachDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getType() {
        return type;
    }

    public TeachDto setType(int type) {
        this.type = type;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public TeachDto setTarget(String target) {
        this.target = target;
        return this;
    }
}
