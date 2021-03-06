package com.ticketopen.services;

import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.dto.CategoryDTO;
import com.ticketopen.dto.CategoryNewDTO;
import com.ticketopen.repositories.CategoryRepository;
import com.ticketopen.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category findById(Integer id) {
        Optional<Category> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found!" +
                        " id: " + id +
                        ", type class: "  + Category.class.getName()));
    }

    public Category fromDTO(CategoryDTO objDTO){
        Department department = new Department(objDTO.getDepartmentId(),null);

        return new Category(objDTO.getId(), objDTO.getName(), department);
    }

    public Category fromDTO(CategoryNewDTO objDTO) {
        Department department = new Department(objDTO.getDepartmentId(),null);

        Category category = new Category(null, objDTO.getName(), department);

        return category;
    }

    public Category updateCategory(Category obj){
        Category newObj = findById(obj.getId());
        updateDate(newObj, obj);
        return repo.save(obj);
    }

    private void updateDate(Category newObj, Category obj) {
        newObj.setName(obj.getName());
        newObj.setDepartment(obj.getDepartment());
    }

    @Transactional
    public Category insertCategory(Category obj) {
        obj.setId(null);
        return repo.save(obj);
    }

}
