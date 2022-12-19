package com.franklloydteh.qumulus.mendixtask.api;

import com.franklloydteh.qumulus.mendixtask.MendixTaskTestApplication;
import com.franklloydteh.qumulus.mendixtask.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * This test requires that the REST API endpoint is available because it does an actual rest call
 * This test does not mock any services.
 * <p>
 * {@link MendixTaskTestApplication} is the application instance that runs during the test
 * and it is where we specify properties for testing
 */

@SpringBootTest(classes = MendixTaskTestApplication.class)
@ContextConfiguration
class TaskApiClientTest {

    @Autowired
    private TaskApiClient taskApiClient;

    @Test
    void shouldGetAllTasks() {
        List<Task> all = this.taskApiClient.getAll();
        Assertions.assertNotNull(all);
        Assertions.assertTrue(all.size() > 0);
    }

}
