package gcg.akula.service.response;

import gcg.akula.entity.response.ApplicationResponse;
import gcg.akula.entity.response.ApplicationResponseWithContent;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.context.ServerRequestContext;
import jakarta.inject.Singleton;

@Singleton
public class ResponseService {


    public HttpResponse<ApplicationResponse> addingSuccess(
            String objectName
    ){
        return HttpResponse.ok(
                new ApplicationResponse(
                        HttpResponse.ok().code(),
                        "Успешно добавлен объект: " + objectName,
                        ServerRequestContext.currentRequest().orElse(null).getPath()
                )
        );
    }

    public HttpResponse<ApplicationResponseWithContent> successGetContent(
            String message,
            Object content
    ){
        return HttpResponse.ok(
                new ApplicationResponseWithContent(
                        HttpResponse.ok().code(),
                        "Успешно получено." + message,
                        ServerRequestContext.currentRequest().orElse(null).getPath(),
                        content
                )
        );
    }
}

