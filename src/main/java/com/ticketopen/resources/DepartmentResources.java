package com.ticketopen.resources;


import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentResources {

    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Department obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
