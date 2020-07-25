package com.ticketopen.dto;

import java.io.Serializable;

public class CommentNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;

    private Integer personId;

    private Integer ticketId;

    public CommentNewDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
