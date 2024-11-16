package com.IIT2ndyr.EventTicketSystem.service;

import com.IIT2ndyr.EventTicketSystem.entity.Event;
import com.IIT2ndyr.EventTicketSystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Add a new event.
     */
    public Event addEvent(Event event) {
        // Initialize sold tickets to 0 for each price tier
        event.setSoldTickets(event.getTicketQuantities().stream()
                .map(quantity -> 0).toList());

        // Initialize available tickets with the total quantity for each price tier
        event.setAvailableTickets(event.getTicketQuantities());
        return eventRepository.save(event);
    }

    /**
     * View all events.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * View a specific event by ID.
     */
    public Optional<Event> getEventById(Long eventId) {
        return eventRepository.findById(eventId);
    }
}
