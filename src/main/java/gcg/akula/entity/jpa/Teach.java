package gcg.akula.entity.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teach {
    @Id
    private long id;
    private String name;
    private int type;
    private String target;

    public Teach() {
    }

    public Teach(long id, String name, int type, String target) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.target = target;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
