package com.IIT2ndyr.EventTicketSystem.controller;

import com.IIT2ndyr.EventTicketSystem.entity.Customer;
import com.IIT2ndyr.EventTicketSystem.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventTicket/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<Long>> getPurchasedTickets(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerPurchasedTickets(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}