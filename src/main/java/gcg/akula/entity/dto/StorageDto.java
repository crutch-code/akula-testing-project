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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
