package gcg.akula.service;

import gcg.akula.entity.dto.StorageDto;
import gcg.akula.repository.StorageRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class StorageService {

    @Inject
    StorageRepository storageRepository;

    public Optional<StorageDto> getFileByName(String fileName) {
        return storageRepository
                .findByName(fileName)
                .map(StorageDto::new);
    }

    /**
     * Загрузка файла в хранилище
     * @param file {@link StorageDto} файл
     * @return {@link StorageDto} только с метаинформацией о файле
     */
    public StorageDto addFile(StorageDto file) {
        //TODO: добавить(?) filePath, если файл не в БД
        return new StorageDto(storageRepository.save(file.toEntity()), true);
    }
}
