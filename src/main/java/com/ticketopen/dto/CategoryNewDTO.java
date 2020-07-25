package com.ticketopen.dto;

import java.io.Serializable;

public class CategoryNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer departmentId;

    public CategoryNewDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

}