package com.example.redis.cache.demo.service;

import com.example.redis.cache.demo.model.Address;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {


    List<Address> addressList;

    {
        addressList = new ArrayList<>();
        addressList.add(new Address(1, "Home", 1));
        addressList.add(new Address(2, "Work", 1));
    }

    @Test
    @DisplayName("Should return a non empty list when the customer id exists")
    void shouldReturnANonEmptyListAddressWhenTheCustomerIdExists() {


    }
}