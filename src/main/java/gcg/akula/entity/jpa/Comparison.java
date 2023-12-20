package gcg.akula.entity.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comparison")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comparison_id_seq")
    @SequenceGenerator(name = "comparison_id_seq", sequenceName = "comparison_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lid", nullable = false)
    private Option lid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rid", nullable = false)
    private Option rid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qid")
    private Question qid;

    public Question getQid() {
        return qid;
    }

    public void setQid(Question qid) {
        this.qid = qid;
    }

    public Comparison() {
    }

    public Comparison(Long id, @NotNull Option lid, @NotNull Option rid) {
        this.id = id;
        this.lid = lid;
        this.rid = rid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getLid() {
        return lid;
    }

    public void setLid(Option lid) {
        this.lid = lid;
    }

    public Option getRid() {
        return rid;
    }

    public void setRid(Option rid) {
        this.rid = rid;
    }

}