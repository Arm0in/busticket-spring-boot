package ir.maktab.busticketspringboot.service.impl;

import ir.maktab.busticketspringboot.domain.Ticket;
import ir.maktab.busticketspringboot.domain.User;
import ir.maktab.busticketspringboot.repository.TicketRepository;
import ir.maktab.busticketspringboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> findAllByUser(User user) {
        return ticketRepository.findAllByUser(user);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

}
