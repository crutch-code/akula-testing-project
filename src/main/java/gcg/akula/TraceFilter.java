package gcg.akula;

import gcg.akula.service.TraceService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ResponseFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ServerFilter("/api/**")
public class TraceFilter {
    private final TraceService traceService;

    public TraceFilter(TraceService traceService) {
        this.traceService = traceService;
    }

    @RequestFilter
    @ExecuteOn(TaskExecutors.BLOCKING)
    public void filterRequest(HttpRequest<?> request) {
        traceService.trace(request);
    }

    @ResponseFilter
    public void filterResponse(MutableHttpResponse<?> res) {

    }
}