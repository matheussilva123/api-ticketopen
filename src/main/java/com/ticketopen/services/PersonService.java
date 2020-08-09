package com.ticketopen.services;

import com.ticketopen.domain.Department;
import com.ticketopen.domain.Person;
import com.ticketopen.domain.enums.Profile;
import com.ticketopen.dto.PersonNewDTO;
import com.ticketopen.repositories.PersonRepository;
import com.ticketopen.security.UserSS;
import com.ticketopen.services.exceptions.AuthorizationException;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private PersonRepository repo;

    public Person findById(Integer id) {
        UserSS user = UserService.authenticated();
        if (user==null || !user.hasRole(Profile.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException("Access denied");
        }


        Optional<Person> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found!" +
                        " id: " + id +
                        ", type class: "  + Person.class.getName()));
    }

    @Transactional
    public Person insertPerson(Person obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Person fromDTO(PersonNewDTO objDTO) {
        Department department = new Department(objDTO.getDepartmentId(),null);

        Person Person = new Person(null, objDTO.getName(),objDTO.getEmail(), department, pe.encode(objDTO.getPassword()));

        return Person;
    }

}
