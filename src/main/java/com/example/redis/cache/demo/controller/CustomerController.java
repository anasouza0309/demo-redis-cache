package com.example.redis.cache.demo.controller;

import com.example.redis.cache.demo.model.Address;
import com.example.redis.cache.demo.model.Customer;
import com.example.redis.cache.demo.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/cache/v1")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/adresses/?id")
    public List<Address> getCAdresses(int id) {
        return customerService.getAddresses(id);
    }
}
