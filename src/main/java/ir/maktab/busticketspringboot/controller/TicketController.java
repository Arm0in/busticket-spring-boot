package ir.maktab.busticketspringboot.controller;

import ir.maktab.busticketspringboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;



}
