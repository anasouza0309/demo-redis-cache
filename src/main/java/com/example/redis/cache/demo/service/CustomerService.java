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


    @Cacheable("products")
    @Override
    public List<Customer> getCustomers() {
        System.out.println("Recovering products");
        emulateLatency();
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

    private void emulateLatency(){
        try {
            long time = 2000L;
            Thread.sleep(time);

        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
