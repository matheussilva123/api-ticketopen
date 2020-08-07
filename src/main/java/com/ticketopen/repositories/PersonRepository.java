package com.ticketopen.repositories;

import com.ticketopen.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Transactional
    Person findByEmail(String email);

}
