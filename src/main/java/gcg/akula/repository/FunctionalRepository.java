package gcg.akula.repository;


import io.micronaut.data.annotation.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.swing.text.html.parser.Entity;

@Repository
public class FunctionalRepository {
    @PersistenceContext
    private EntityManager manager;

}
