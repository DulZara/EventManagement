package com.IIT2ndyr.EventTicketSystem.repository;

import com.IIT2ndyr.EventTicketSystem.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenderRepository extends JpaRepository<Vendor, Long> {
}
