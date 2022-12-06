package com.example.demo.service.impl;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Page<Customer> getCustomerListPage(Pageable pageable, String name) {
        return customerRepo.getCustomerListPage(pageable,name);
    }

    @Override
    public List<Customer> getCustomerList(String name) {
        return customerRepo.getCustomerList(name);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findByIdCustomer(Integer id) {
        return customerRepo.findByIdCustomer(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepo.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepo.updateCustomer(customer.getName(),
                                    customer.getAge(),
                                    customer.getAddress(),
                                    customer.getPhoneNumber(),
                                    customer.getGender(),
                                    customer.getCreateDate(),
                                    customer.getId());
    }
}
