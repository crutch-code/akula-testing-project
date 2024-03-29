package gcg.akula.controller;

import gcg.akula.entity.dto.StorageDto;
import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.service.StorageService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller("/api/storage")
public class StorageController {

    @Inject
    StorageService storageService;

    @Get(value = "/{name}" , produces = MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<byte[]> getStorageFile(String name) {
        Optional<StorageDto> file = storageService.getFileByName(name);
        if(file.isPresent()) {
            return HttpResponse.ok(file.get().getData())
                    .header("Content-disposition", "attachment; filename=\"" + name + "\"; filename*=UTF-8''" + URLEncoder.encode(name, StandardCharsets.UTF_8).replace("+", "%20"));
        }
        return HttpResponse.notFound();
    }

    @Post(value="/", consumes = MediaType.ALL)
    public ApplicationResponse<StorageDto> postStorageFile(String name, String type, byte[] data) {
        return ApplicationResponse.ok(storageService.addFile(new StorageDto(null, name, type, data)));
    }

}
