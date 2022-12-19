package com.franklloydteh.qumulus.mendixtask;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.franklloydteh.qumulus.mendixtask.api")
@PropertySource("classpath:test.properties")
public class MendixTaskTestApplication {
}
