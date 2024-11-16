package com.IIT2ndyr.EventTicketSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @ElementCollection
    private List<Double> ticketPrices;  // List of ticket price tiers

    @ElementCollection
    private List<Integer> ticketQuantities; // Number of tickets per price tier

    @ElementCollection
    private List<Integer> availableTickets; // Available tickets per price tier

    @ElementCollection
    private List<Integer> soldTickets; // Sold tickets per price tier

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public List<Double> getTicketPrices() {
        return ticketPrices;
    }

    public void setTicketPrices(List<Double> ticketPrices) {
        this.ticketPrices = ticketPrices;
    }

    public List<Integer> getTicketQuantities() {
        return ticketQuantities;
    }

    public void setTicketQuantities(List<Integer> ticketQuantities) {
        this.ticketQuantities = ticketQuantities;
    }

    public List<Integer> getAvailableTickets() {
        return availableTickets;
    }

    public void setAvailableTickets(List<Integer> availableTickets) {
        this.availableTickets = availableTickets;
    }

    public List<Integer> getSoldTickets() {
        return soldTickets;
    }

    public void setSoldTickets(List<Integer> soldTickets) {
        this.soldTickets = soldTickets;
    }

}
