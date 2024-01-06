package com.izznazrin;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping()
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // @GetMapping("/test")
    // public GreetResponse greet() {
    //     GreetResponse response = new GreetResponse(
    //         "hell",
    //         List.of("Java", "JavaScript"),
    //         new Person("Alex", 28, 30000)
    //     );
    //     return response;
    // }

    // record Person(String name, int age, double savings) {
    // }

    // record GreetResponse(
    //         String greet,
    //         List<String> favProgrammingLanguages,
    //         Person person) {
    // }
}
