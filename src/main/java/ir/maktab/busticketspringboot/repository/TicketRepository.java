package ir.maktab.busticketspringboot.repository;

import ir.maktab.busticketspringboot.domain.Ticket;
import ir.maktab.busticketspringboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUser(User user);
}
