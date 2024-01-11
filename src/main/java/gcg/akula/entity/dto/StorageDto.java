package gcg.akula.entity.dto;

import gcg.akula.entity.jpa.Storage;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class StorageDto implements DTO<Storage> {
    private Long id;
    private String name;
    private String type;
    private byte[] data;

    public StorageDto(Long id, String name, String type, byte[] data) {
        this.id = id;
        this.name = name;
        this.data = data;
        this.type = type;
    }

    public StorageDto(Storage storage) {
        id = storage.getId();
        name = storage.getName();
        data = storage.getData();
        type = storage.getType();
    }

    public StorageDto(Storage storage, boolean withoutData) {
        id = storage.getId();
        name = storage.getName();
        type = storage.getType();
        if(!withoutData)
            data = storage.getData();
    }

    @Override
    public Storage toEntity() {
        return new Storage(id, name, type, data);
    }

    public Long getId() {
        return id;
    }

    public StorageDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StorageDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public StorageDto setType(String type) {
        this.type = type;
        return this;
    }

    public byte[] getData() {
        return data;
    }

    public StorageDto setData(byte[] data) {
        this.data = data;
        return this;
    }
}
