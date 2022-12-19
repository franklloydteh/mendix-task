package com.franklloydteh.qumulus.mendixtask.api;

import com.franklloydteh.qumulus.mendixtask.model.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * This API Client consumes the Mendix Published Rest API.
 * This is implemented using Spring WebFlux.
 * Normally we would have an interface for this:
 *      - so that implementation details are hidden from classes that use it
 *      - so that we can easily change the implementation (e.g. migrating from Spring REST Template)
 */
@Service
public class TaskApiClient {

    @Value("${mendix.api.url}")
    private String MENDIX_API_URL;

    private static final String TASK_ENDPOINT = "/task";

    private WebClient webClient;

    /**
     * I normally implement this as a separate Bean with some custom implementations,
     *      such as auto logging request and responses made using this webclient
     */
    @PostConstruct
    private void init() {
        this.webClient = WebClient.create(MENDIX_API_URL);
    }


    /**
     * This gets all tasks from the Mendix Task API.
     *      Best practice is to do pagination + filters.
     */
    public List<Task> getAll() {
        return webClient.get()
                .uri(TASK_ENDPOINT)
                .header("accept", "application/json")
                .retrieve()
                .bodyToFlux(Task.class)
                .collectList()
                .block();
    }

}
