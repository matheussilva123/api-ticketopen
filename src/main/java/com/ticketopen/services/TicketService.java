package com.ticketopen.services;

import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.domain.Person;
import com.ticketopen.domain.Ticket;
import com.ticketopen.domain.enums.StateTicket;
import com.ticketopen.dto.TicketDTO;
import com.ticketopen.dto.TicketNewDTO;
import com.ticketopen.repositories.CategoryRepository;
import com.ticketopen.repositories.DepartmentRepository;
import com.ticketopen.repositories.PersonRepository;
import com.ticketopen.repositories.TicketRepository;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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


    @Transactional
    public Ticket insertTicket(Ticket obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Ticket updateTicket(Ticket obj) {
        Ticket newObj = findById(obj.getId());
        updateDate(newObj, obj);
        return repo.save(obj);
    }

    public List<Ticket> findAll(){
        return repo.findAll();
    }

    public Page<Ticket> findPage(Integer page, Integer linesPerPage,
                                 String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Ticket fromDTO(TicketDTO objDto){
        return new Ticket(objDto.getId(), objDto.getDescription(), objDto.getOpeningDate(), objDto.getClosingDate(), objDto.getState(),null);
    }

    public Ticket fromDTO(TicketNewDTO objDto){

        Department department = new Department(objDto.getDepartmentid(), null);
        Category category = new Category(objDto.getCategoryId(), null, department);

        Ticket ticket = new Ticket(null, objDto.getDescription(),objDto.getOpeningDate(),
                objDto.getClosingDate(), StateTicket.toEnum(objDto.getState()), category);


        return ticket;
    }

    private void updateDate(Ticket newObj,  Ticket obj){
        newObj.setDescription(obj.getDescription());
        newObj.setClosingDate(obj.getClosingDate());
        newObj.setState(obj.getState());
    }

}
