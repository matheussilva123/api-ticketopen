package com.ticketopen.dto;

import com.ticketopen.domain.Department;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;

    @NotEmpty(message="It cannot be empty")
    @Length(min = 5, max = 20, message = "The length must be between 5 and 80 characters")
    private String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Department obj){
        id = obj.getId();
        name = obj.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
