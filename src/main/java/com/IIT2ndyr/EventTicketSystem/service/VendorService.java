package com.IIT2ndyr.EventTicketSystem.service;

import com.IIT2ndyr.EventTicketSystem.entity.Event;
import com.IIT2ndyr.EventTicketSystem.entity.Vendor;
import com.IIT2ndyr.EventTicketSystem.repository.EventRepository;
import com.IIT2ndyr.EventTicketSystem.repository.VenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {
    private final VenderRepository vendorRepository;
    private final EventRepository eventRepository;

    public VendorService(VenderRepository vendorRepository, EventRepository eventRepository) {
        this.vendorRepository = vendorRepository;
        this.eventRepository = eventRepository;
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    public List<Event> getVendorEvents(Long vendorId) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(vendorId);
        if (vendorOptional.isPresent()) {
            Vendor vendor = vendorOptional.get();
            return vendor.getEventIds()
                    .stream()
                    .map(eventRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Vendor not found with ID: " + vendorId);
        }
    }
}
