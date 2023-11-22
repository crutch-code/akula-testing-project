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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
