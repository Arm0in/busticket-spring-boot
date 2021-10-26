package ir.maktab.busticketspringboot.service;


import ir.maktab.busticketspringboot.domain.Trip;

import java.time.LocalDate;
import java.util.List;

public interface TripService {
    List<Trip> findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(String origin, String destination, LocalDate departureDate);
}
