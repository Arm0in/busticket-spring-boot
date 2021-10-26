package ir.maktab.busticketspringboot.controller;

import ir.maktab.busticketspringboot.domain.Ticket;
import ir.maktab.busticketspringboot.domain.Trip;
import ir.maktab.busticketspringboot.domain.User;
import ir.maktab.busticketspringboot.service.TicketService;
import ir.maktab.busticketspringboot.service.TripService;
import ir.maktab.busticketspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TripService tripService;
    @Autowired
    private UserService userService;

    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchase(@RequestBody Ticket ticket) {
        System.out.println();
        try {
            User currentUser = userService.findByToken(ticket.getUser().getToken());
            Optional<Trip> trip = tripService.findById(ticket.getTrip().getId());
            if (trip.isEmpty() || currentUser == null) {
                throw new RuntimeException("Invalid!");
            }
            ticket.setTrip(trip.get());
            ticket.setUser(currentUser);
            System.out.println(ticket);
            ticketService.create(ticket);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/get-tickets")
    public ResponseEntity<List<Ticket>> getTickets(@RequestBody String token) {
        try {
            User currentUser = userService.findByToken(token);
            List<Ticket> ticketList = ticketService.findAllByUser(currentUser);
            return new ResponseEntity<>(ticketList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/find-ticket")
    public ResponseEntity<Ticket> findTicketById(@RequestBody String id) {
        try {
            Ticket ticket = ticketService.findById(Long.parseLong(id)).get();
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/delete-ticket")
    public ResponseEntity deleteTicket(@RequestParam("id") String id) {
        try {
            ticketService.deleteById(Long.parseLong(id));
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
