package com.franklloydteh.qumulus.mendixtask;

import com.franklloydteh.qumulus.mendixtask.api.TaskApiClient;
import com.franklloydteh.qumulus.mendixtask.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MendixTaskApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MendixTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication
                .run(MendixTaskApplication.class, args)
                .close();
    }

    /**
     * This is executed when you run the application.
     * In this I just retrieve and list all the tasks in the command line,
     * This is intended as POC that we can retrieve the data from Mendix and
     * - maybe we save the data in a data warehouse
     * - maybe we sync the data to a third party by using the third party api
     */
    @Bean
    public static CommandLineRunner init(TaskApiClient taskApiClient) {
        return args -> {

            List<Task> all = taskApiClient.getAll();

            LOGGER.info("Number of Tasks Retrieved: " + all.size());
            all.forEach(task -> LOGGER.info("TASK: " + task.getTitle()));

        };
    }

}
