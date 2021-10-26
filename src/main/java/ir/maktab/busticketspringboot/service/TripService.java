package ir.maktab.busticketspringboot.service;


import ir.maktab.busticketspringboot.domain.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TripService {
    List<Trip> findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(String origin, String destination, LocalDate departureDate);
    Optional<Trip> findById(Long id);
}
