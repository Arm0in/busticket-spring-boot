package ir.maktab.busticketspringboot.service.impl;

import com.github.javafaker.Faker;
import ir.maktab.busticketspringboot.domain.Trip;
import ir.maktab.busticketspringboot.repository.TripRepository;
import ir.maktab.busticketspringboot.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
//        Faker faker = new Faker();
//        for (int i = 0; i < 5; i++) {
//            Trip trip = new Trip();
//            trip.setOrigin(faker.address().cityName());
//            trip.setDestination(faker.address().cityName());
//            LocalDateTime randomDateTime = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//            trip.setDepartureDate(randomDateTime.toLocalDate());
//            trip.setDepartureTime(randomDateTime.toLocalTime());
//            tripRepository.save(trip);
//        }
    }

    @Override
    public List<Trip> findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(String origin, String destination, LocalDate departureDate) {

        return tripRepository.findAllByOriginAndDestinationAndDepartureDateOrderByDepartureTime(origin, destination, departureDate);
    }

    @Override
    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }
}
