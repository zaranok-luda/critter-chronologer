package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PetRepository petRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getAllCustomersById(Set<Long> ids) {
        return customerRepository.findAllById(ids);
    }

    public Customer getCustomerByID(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer getCustomerByPetID(long id) {
        return customerRepository.findByPetsId(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer for Pet id: %s is not found", id));
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerByID(Long customerID) {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
        customerRepository.delete(customer);
    }

}