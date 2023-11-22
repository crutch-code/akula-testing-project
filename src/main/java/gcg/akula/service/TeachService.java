package gcg.akula.service;

import gcg.akula.entity.dto.TeachDto;
import gcg.akula.repository.TeachRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class TeachService {
    @Inject
    TeachRepository teachRepository;


    public Page<TeachDto> getAssignedToUser(long uid, Pageable pageable) {
        return teachRepository
                .findAllAssignedTo(uid, pageable)
                .map(TeachDto::new);
    }
}
