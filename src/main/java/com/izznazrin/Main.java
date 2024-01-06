package com.izznazrin;

import java.util.List;

import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/test")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
            "hell",
            List.of("Java", "JavaScript"),
            new Person("Alex", 28, 30000)
        );
        return response;
    }

    record Person(String name, int age, double savings) {
    }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person) {
    }
}
