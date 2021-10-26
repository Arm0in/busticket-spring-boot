package ir.maktab.busticketspringboot.service;

import ir.maktab.busticketspringboot.domain.Ticket;
import ir.maktab.busticketspringboot.domain.User;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket create(Ticket ticket);
    List<Ticket> findAllByUser(User user);
    Optional<Ticket> findById(Long id);
    void deleteById(Long id);
}
