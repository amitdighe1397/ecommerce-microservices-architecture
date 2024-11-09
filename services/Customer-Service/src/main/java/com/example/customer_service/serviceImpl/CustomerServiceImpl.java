package com.example.customer_service.serviceImpl;

import com.example.customer_service.dto.CustomerRequest;
import com.example.customer_service.exceptions.ResourceNotFoundException;
import com.example.customer_service.modal.Customer;
import com.example.customer_service.repository.CustomerRepository;
import com.example.customer_service.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerRequest createCustomer(CustomerRequest customerRequest) {
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        Customer customer1 = customerRepository.save(customer);
        CustomerRequest customerRequest1 = modelMapper.map(customer1, CustomerRequest.class);
        return customerRequest1;
    }

    @Override
    public CustomerRequest updateCustomer(CustomerRequest customerRequest, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot Update Customer No Customer Found"));
        customer.setFirstname(customerRequest.getFirstname());
        customer.setLastname(customerRequest.getLastname());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        Customer customer1 = customerRepository.save(customer);
        CustomerRequest customerRequest1 = modelMapper.map(customer1, CustomerRequest.class);
        return customerRequest1;

    }

    @Override
    public List<CustomerRequest> findAllCustomers() {
        List<Customer> list = customerRepository.findAll();
        List<CustomerRequest> list1 = list.stream()
                .map(customer -> modelMapper.map(customer, CustomerRequest.class))
                .collect(Collectors.toList());
        return list1;
    }

    @Override
    public CustomerRequest customerFindById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot Update Customer No Customer Found"));
        CustomerRequest customerRequest = modelMapper.map(customer, CustomerRequest.class);
        return customerRequest;
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot Delete Customer No Customer Found"));
        customerRepository.delete(customer);
    }

}
