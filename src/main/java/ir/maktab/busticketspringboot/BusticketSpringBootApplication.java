package ir.maktab.busticketspringboot;

import com.github.javafaker.Faker;
import ir.maktab.busticketspringboot.domain.Trip;
import ir.maktab.busticketspringboot.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class BusticketSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusticketSpringBootApplication.class, args);
    }

}
