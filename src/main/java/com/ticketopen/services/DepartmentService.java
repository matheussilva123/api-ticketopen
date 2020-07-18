package com.ticketopen.services;

import com.ticketopen.domain.Department;
import com.ticketopen.repositories.DepartmentRepository;
import com.ticketopen.services.exceptions.DataIntegrityException;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Department insertDepartment(Department obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Department update(Department obj) {
        findById(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repo.deleteById(id);
        } catch (
                DataIntegrityViolationException e) {
            throw new DataIntegrityException("It is not possible to delete an" +
                    " entity associated with another. ");
        }

    }
}
