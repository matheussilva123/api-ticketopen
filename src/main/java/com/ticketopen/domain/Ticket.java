package com.ticketopen.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ticketopen.domain.enums.StateTicket;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String description;

    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date openingDate;
    @JsonFormat(locale = "dd/MM/yyyy HH:mm")
    private Date closingDate;

    private Integer state;

    public Ticket(Integer id, String description, Date openingDate, Date closingDate, StateTicket state) {
        this.id = id;
        this.description = description;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.state = (state == null) ? null : state.getId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
