package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerService {
    Page<Customer> getCustomerListPage(Pageable pageable, String name);
    List<Customer> getCustomerList(String name);
    void createCustomer(Customer customer);

    Customer findByIdCustomer(Integer id);

    void deleteCustomer(Integer id);

    void updateCustomer(Customer customer);
}
