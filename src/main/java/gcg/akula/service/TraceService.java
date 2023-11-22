package gcg.akula.service;

import io.micronaut.http.HttpRequest;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TraceService {
    private static final Logger log = LoggerFactory.getLogger(TraceService.class);

    public void trace(HttpRequest<?> request) {
        log.info("[{}] {} {}", request.getRemoteAddress(), request.getMethodName(), request.getUri());
    }
}