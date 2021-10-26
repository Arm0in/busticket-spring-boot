package ir.maktab.busticketspringboot.service.impl;

import ir.maktab.busticketspringboot.repository.TicketRepository;
import ir.maktab.busticketspringboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
}
