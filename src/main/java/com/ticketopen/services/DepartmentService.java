package com.ticketopen.services;

import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public Department findById(Integer id) {
        Optional<Department> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
