package com.ticketopen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class TicketNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotEmpty(message = "It cannot be empty")
    @Length(min = 10, max = 250, message = "The length must be between 10 and 250 characters")
    private String description;

    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date openingDate;

    private Integer categoryId;

    private Integer personId;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
