package ir.maktab.busticketspringboot.repository;

import ir.maktab.busticketspringboot.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(String origin, String destination, LocalDate departureDate);
}
