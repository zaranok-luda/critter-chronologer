package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Component
public class CustomerConverter {

    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setNotes(customerDTO.getNotes());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .notes(customer.getNotes())
                .phoneNumber(customer.getPhoneNumber())
                .petIds(
                        ofNullable(customer.getPets())
                                .orElse(Set.of())
                                .stream()
                                .map(Pet::getId)
                                .collect(Collectors.toList())
                ).build();
    }

    public List<CustomerDTO> customerListToCustomerDTOList(List<Customer> customers) {
        return customers.stream().map(this::customerToCustomerDTO).toList();
    }
}