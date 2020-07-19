package com.ticketopen.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ticketopen.domain.Ticket;
import com.ticketopen.domain.enums.StateTicket;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

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


    public TicketDTO() {
    }

    public TicketDTO(Ticket obj) {
        id = obj.getId();
        description = obj.getDescription();
        openingDate = obj.getOpeningDate();
        closingDate = obj.getClosingDate();
        this.state = obj.getState();
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
}
