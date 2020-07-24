package com.ticketopen.resources;

import com.ticketopen.domain.Ticket;
import com.ticketopen.dto.TicketDTO;
import com.ticketopen.dto.TicketNewDTO;
import com.ticketopen.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    @Autowired
    private TicketService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Ticket obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertTicket(@Valid @RequestBody TicketNewDTO objDto) {
        Ticket obj = service.fromDTO(objDto);
        obj = service.insertTicket(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateTicket(
            @RequestBody Ticket obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.updateTicket(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TicketDTO>> findAll() {
        List<Ticket> list = service.findAll();
        List<TicketDTO> dtoList = list.stream().map(TicketDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<TicketDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "openingDate")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction) {
        Page<Ticket> list = service.findPage(page, linesPerPage, orderBy,direction);
        Page<TicketDTO> dtoList = list.map(TicketDTO::new);
        return ResponseEntity.ok().body(dtoList);
    }

}
