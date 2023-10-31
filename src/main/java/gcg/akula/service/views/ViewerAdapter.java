package gcg.akula.service.views;

public interface ViewerAdapter <T, E> {
    T convert(E entity);
}
