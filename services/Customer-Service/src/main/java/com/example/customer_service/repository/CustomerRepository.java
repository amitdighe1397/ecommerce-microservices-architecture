package com.example.customer_service.repository;

import com.example.customer_service.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
