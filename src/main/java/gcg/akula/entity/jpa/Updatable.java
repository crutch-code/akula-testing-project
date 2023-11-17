package gcg.akula.entity.jpa;

public interface Updatable<E, D> {
    E update (D dto);
}
