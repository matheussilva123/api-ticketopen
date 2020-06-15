package com.ticketopen.services;

import com.ticketopen.domain.Person;
import com.ticketopen.repositories.PersonRepository;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public Person findById(Integer id) {
        Optional<Person> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found!" +
                        " id: " + id +
                        ", type class: "  + Person.class.getName()));
    }

}
