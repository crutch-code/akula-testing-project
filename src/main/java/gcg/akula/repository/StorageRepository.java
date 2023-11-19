package gcg.akula.repository;

import gcg.akula.entity.jpa.Storage;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class StorageRepository implements CrudRepository<Storage, Long> {
    @Inject
    EntityManager entityManager;

    @ReadOnly
    public Optional<Storage> findByName(String name) {
        List<Storage> files = entityManager
                .createQuery("select S from Storage S where S.name=(:name)", Storage.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultList();
        return files.isEmpty() ? Optional.empty() : Optional.of(files.get(0));
    }
}
