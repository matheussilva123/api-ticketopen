package com.ticketopen.services;

import com.ticketopen.domain.Department;
import com.ticketopen.dto.DepartmentDTO;
import com.ticketopen.repositories.DepartmentRepository;
import com.ticketopen.services.exceptions.DataIntegrityException;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    public Department insertDepartment(Department obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Department updateDepartment(Department obj) {
        Department newObj = findById(obj.getId());
        updateDate(newObj, obj);
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

    public List<Department> findAll(){
     return repo.findAll();
    }

    public Page<Department> findPage(Integer page, Integer linesPerPage,
                                     String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Department fromDTO(DepartmentDTO objDto){
        return new Department(objDto.getId(), objDto.getName());
    }

    private void updateDate(Department newObj, Department obj) {
        newObj.setName(obj.getName());
    }

}
