package com.ticketopen.services;

import com.ticketopen.domain.Department;
import com.ticketopen.repositories.DepartmentRepository;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public Department findById(Integer id) {
        Optional<Department> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found!" +
                        " id: " + id +
                        ", type class: " + Department.class.getName()));
    }

}
