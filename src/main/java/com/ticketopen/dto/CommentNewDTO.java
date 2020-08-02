package com.ticketopen.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CommentNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotEmpty(message = "It cannot be empty")
    @Length(min = 10, max = 250, message = "The length must be between 10 and 250 characters")
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
