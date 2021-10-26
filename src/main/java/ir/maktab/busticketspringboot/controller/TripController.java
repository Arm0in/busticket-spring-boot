package ir.maktab.busticketspringboot.controller;

import ir.maktab.busticketspringboot.domain.Trip;
import ir.maktab.busticketspringboot.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/find-trips")
    public ResponseEntity<List<Trip>> displayTrips(@RequestBody Trip trip) {
        List<Trip> tripList = tripService.findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(trip.getOrigin(), trip.getDestination(), trip.getDepartureDate());
        System.out.println(tripList);
        return new ResponseEntity<>(tripList, HttpStatus.OK);
    }
}
