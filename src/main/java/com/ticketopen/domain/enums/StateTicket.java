package com.ticketopen.domain.enums;

import org.aspectj.weaver.patterns.Pointcut;

public enum StateTicket {

    OPEN(1, "Open"),
    ATTENDING(2, "Attending"),
    CLOSED(3, "Closed");

    private int id;
    private String description;

    private StateTicket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static StateTicket toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (StateTicket x : StateTicket.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + id);
    }

}
