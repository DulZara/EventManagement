package com.IIT2ndyr.EventTicketSystem.service;

import com.IIT2ndyr.EventTicketSystem.entity.Customer;
import com.IIT2ndyr.EventTicketSystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Long> getCustomerPurchasedTickets(Long customerId) {
        return customerRepository.findById(customerId)
                .map(Customer::getPurchasedTickets)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

}
