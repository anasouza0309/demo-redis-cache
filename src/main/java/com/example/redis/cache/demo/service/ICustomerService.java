package com.example.redis.cache.demo.service;

import com.example.redis.cache.demo.model.Address;
import com.example.redis.cache.demo.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getCustomers();

    List<Address> getAddresses(int id);
}
