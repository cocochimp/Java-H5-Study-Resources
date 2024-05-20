package com.koko.service;

import org.springframework.stereotype.Component;

@Component //放在容器中
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "《狂神说Java》";
    }
}