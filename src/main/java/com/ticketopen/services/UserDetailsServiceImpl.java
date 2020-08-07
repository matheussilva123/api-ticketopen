package com.ticketopen.services;

import com.ticketopen.domain.Person;
import com.ticketopen.repositories.PersonRepository;
import com.ticketopen.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = repo.findByEmail(email);

        if(person == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(person.getId(), person.getEmail(), person.getPassword(), person.getProfiles());
    }
}
