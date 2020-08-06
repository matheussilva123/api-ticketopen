package com.ticketopen.dto;

import javax.validation.constraints.NotEmpty;

public class PersonNewDTO {

    private Integer id;

    @NotEmpty(message = "It cannot be empty")
    private String name;

    @NotEmpty(message = "It cannot be empty")
    private String email;

    @NotEmpty(message = "It cannot be empty")
    private String password;

    @NotEmpty(message = "It cannot be empty")
    private Integer departmentId;

    public PersonNewDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
