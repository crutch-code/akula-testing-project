package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Department;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

@Serdeable
public class DepartmentDto implements DTO<Department> {
    private Long id;
    private String name;
    private Boolean disabled = false;


    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.disabled = department.getDisabled();
    }

    @Override
    public Department toEntity() {
        return new Department(this.id, this.name, this.disabled);
    }

    public Long getId() {
        return id;
    }

    public DepartmentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DepartmentDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public DepartmentDto setDisabled(Boolean disabled) {
        this.disabled = disabled;
        return this;
    }
}
