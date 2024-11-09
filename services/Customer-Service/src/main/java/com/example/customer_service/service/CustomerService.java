package com.example.customer_service.service;

import com.example.customer_service.dto.CustomerRequest;

import java.util.List;

public interface CustomerService {

    public CustomerRequest createCustomer(CustomerRequest customerRequest);

    public CustomerRequest updateCustomer(CustomerRequest customerRequest, Long id);

    public List<CustomerRequest> findAllCustomers();

    public CustomerRequest customerFindById(Long id);

    public void deleteCustomer(Long id);

}
