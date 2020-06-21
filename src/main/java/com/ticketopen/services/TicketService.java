package com.ticketopen.services;

import com.ticketopen.domain.Ticket;
import com.ticketopen.repositories.TicketRepository;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repo;

    public Ticket findById(Integer id) {
        Optional<Ticket> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found!" +
                        " id: " + id +
                        ", type class: "  + Ticket.class.getName()));
    }

}
