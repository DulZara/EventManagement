package com.IIT2ndyr.EventTicketSystem.repository;

import com.IIT2ndyr.EventTicketSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
