package com.zhl.test.webflux.controller;

import com.zhl.test.webflux.model.Customer;
import com.zhl.test.webflux.model.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class TestFluxController {

    @GetMapping("/{user}")
    public Mono<User> getUser(@PathVariable Long user) {
        // ...
        User u = new User();
        u.setId("2222222222222");
        u.setName("name---------");
        return Mono.just(u);
    }

//    @GetMapping("/{user}/customers")
//    public Flux<Customer> getUserCustomers(@PathVariable Long user) {
//        // ...
//        Customer customer = new Customer();
//        customer.setCustomerId("23221212112");
//        customer.setCustomerName("233232323232");
//
//        return Mono.just(customer);
//    }

    @DeleteMapping("/{user}")
    public Mono<User> deleteUser(@PathVariable Long user) {
        // ...
        User u = new User();
        u.setId("2222222222222");
        u.setName("name---------");
        return Mono.just(u);
    }
}