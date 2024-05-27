package com.example.redis.cache.demo.service;

import com.example.redis.cache.demo.model.Address;
import com.example.redis.cache.demo.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {


    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                Customer.builder().id(1).name("XXXXXXXX").build(),
                Customer.builder().id(2).name("YYYYYYYY").build(),
                Customer.builder().id(3).name("AAAAAAAA").build());
    }

    @Override
    @Cacheable("addresses")
    public List<Address> getAddresses(int id) {

        return Arrays.asList(
                        Address.builder().id(1).name("XXXXXXXX").customerId(1).build(),
                        Address.builder().id(2).name("YYYYYYYY").customerId(1).build(),
                        Address.builder().id(3).name("AAAAAAAA").customerId(2).build())
                .stream().filter(c -> c.getCustomerId() == id).toList();
    }
}
