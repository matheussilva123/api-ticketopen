package com.ticketopen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ticketopen.domain.Person;
import com.ticketopen.domain.Ticket;
import com.ticketopen.domain.enums.StateTicket;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

public class TicketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="It cannot be empty")
    @Length(min = 10, max = 250, message = "The length must be between 10 and 250 characters")
    private String description;

    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date openingDate;

    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date closingDate;

    private StateTicket state;

    private Integer categoryId;

    private String nameCategory;

    private Integer departmentId;

    private String nameDepartment;


    public TicketDTO() {
    }

    public TicketDTO(Ticket obj) {
        id = obj.getId();
        description = obj.getDescription();
        openingDate = obj.getOpeningDate();
        closingDate = obj.getClosingDate();
        this.state = obj.getState();
        categoryId = obj.getCategory().getId();
        nameCategory = obj.getCategory().getName();
        departmentId = obj.getCategory().getDepartment().getId();
        nameDepartment = obj.getCategory().getDepartment().getName();
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public StateTicket getState() {
        return state;
    }

    public void setState(StateTicket state) {
        this.state = state;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
}
