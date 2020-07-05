package com.ticketopen.domain;

import com.ticketopen.domain.enums.StateTicket;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TicketTest {

    @Test
    public void ChangeTicketStatusTest() throws ParseException {
        //given
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Department dep1 = new Department(1, "Tecnologia");
        Category category = new Category(1, "Infomatica", dep1);
        Ticket ticket = new Ticket(1, "isTest",
                sdf.parse("19/05/1999 19:19"),
                sdf.parse("19/05/1999 19:19"),
                StateTicket.OPEN, category);
        //when
        ticket.setState(StateTicket.ATTENDING);

        //then
        Assert.isTrue(StateTicket.ATTENDING == ticket.getState() , "Test Passed");

    }

}
