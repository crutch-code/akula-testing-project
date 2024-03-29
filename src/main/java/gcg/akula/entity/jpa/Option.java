package gcg.akula.entity.jpa;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "option")
@Serdeable
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_id_seq")
    @SequenceGenerator(name = "option_id_seq", sequenceName = "option_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "content", nullable = false, length = Integer.MAX_VALUE)
    private String content;

    @NotNull
    @Column(name = "is_left", nullable = false)
    private Boolean isLeft = false;

    public Option(Long id, @NotNull String content, @NotNull Boolean isLeft) {
        this.id = id;
        this.content = content;
        this.isLeft = isLeft;
    }

    public Option() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getLeft() {
        return isLeft;
    }

    public void setLeft(Boolean left) {
        isLeft = left;
    }
}