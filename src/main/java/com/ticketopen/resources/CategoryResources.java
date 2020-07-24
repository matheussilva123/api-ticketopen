package com.ticketopen.resources;

import com.ticketopen.domain.Category;
import com.ticketopen.dto.CategoryDTO;
import com.ticketopen.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO objDTO,
                                       @PathVariable Integer id) {
        Category obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.updateCategory(obj);
        return ResponseEntity.noContent().build();
    }

}
