package com.ticketopen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TicketNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String description;
    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date openingDate;
    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date closingDate;
    private Integer state;

    private Integer categoryId;

    private Integer Departmentid;

    //TODO insert person in DTO

    public TicketNewDTO() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDepartmentid() {
        return Departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        Departmentid = departmentid;
    }

}
