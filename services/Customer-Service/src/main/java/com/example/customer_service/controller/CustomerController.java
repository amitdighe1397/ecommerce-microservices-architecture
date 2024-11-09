package com.example.customer_service.controller;

import com.example.customer_service.dto.CustomerRequest;
import com.example.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerRequest> createCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerRequest customerRequest1 = customerService.createCustomer(customerRequest);
        return new ResponseEntity<CustomerRequest>(customerRequest1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerRequest> updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable Long id) {
        CustomerRequest customerRequest1 = customerService.updateCustomer(customerRequest, id);
        return new ResponseEntity<CustomerRequest>(customerRequest1, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerRequest>> findAllCustomers() {
        List<CustomerRequest> list = customerService.findAllCustomers();
        return new ResponseEntity<List<CustomerRequest>>(list, HttpStatus.FOUND);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<CustomerRequest> customerFindById(@PathVariable Long id) {
        CustomerRequest request = customerService.customerFindById(id);
        return new ResponseEntity<CustomerRequest>(request, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted Successfully", HttpStatus.ACCEPTED);
    }
}
