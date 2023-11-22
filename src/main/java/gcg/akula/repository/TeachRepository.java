package gcg.akula.repository;

import gcg.akula.entity.jpa.Teach;
import gcg.akula.utils.ResourceLoader;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeachRepository {
    @Inject
    private EntityManager entityManager;

    @ReadOnly
    public Page<Teach> findAllAssignedTo(long uid, Pageable pageable) {
        Optional<String> sql = ResourceLoader.load("/sql/findAllAssignedTo.sql");
        long count = 0;
        List<Teach> teaches = new ArrayList<>();
        if(sql.isPresent()) {
            count = (Long) entityManager
                    .createNativeQuery("select count(*) from (" + sql.get() + ")")
                    .setParameter("uid", uid)
                    .getSingleResult();
            teaches = ((List<Object[]>)entityManager
                    .createNativeQuery(sql.get())
                    .setParameter("uid", uid)
                    .setMaxResults(pageable.getSize())
                    .setFirstResult((int) pageable.getOffset())
                    .getResultList())
                    .stream()
                    .map(t -> new Teach((long)t[0], (String)t[1], (int)t[2], (String)t[3]))
                    .collect(Collectors.toList());
        }
        return Page.of(teaches, pageable, count);
    }
}
