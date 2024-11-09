package com.example.customer_service.modal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String zipcode;
    
    

}
