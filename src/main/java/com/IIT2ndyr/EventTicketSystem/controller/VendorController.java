package com.IIT2ndyr.EventTicketSystem.controller;

import com.IIT2ndyr.EventTicketSystem.entity.Event;
import com.IIT2ndyr.EventTicketSystem.entity.Vendor;
import com.IIT2ndyr.EventTicketSystem.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EventTicket/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.addVendor(vendor));
    }
    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getVendorEvents(@PathVariable Long id) {
        return ResponseEntity.ok(vendorService.getVendorEvents(id));
    }
}