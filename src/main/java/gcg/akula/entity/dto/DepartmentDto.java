package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Department;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class DepartmentDto implements DTO<Department> {
    private Long id;
    private String name;

    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.name = department.getName();
    }

    @Override
    public Department toEntity() {
        return new Department(this.id, this.name);
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
}
