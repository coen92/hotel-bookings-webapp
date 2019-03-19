package com.coen92.projects.web.hotelbookings.seed;

import com.coen92.projects.web.hotelbookings.api.BookingRepository;
import com.coen92.projects.web.hotelbookings.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner { //CLR initializes their methods when application starts

    private BookingRepository repository;

    @Autowired
    public DatabaseSeeder(BookingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>(addHotelBookings());

        repository.saveAll(bookings);
    }

    private List<HotelBooking> addHotelBookings() {
        List<HotelBooking> bookingList = new ArrayList<>();

        bookingList.add(new HotelBooking("Marriot", 250, 5));
        bookingList.add(new HotelBooking("Grand Hotel", 150, 3));
        bookingList.add(new HotelBooking("Versal", 350, 6));
        bookingList.add(new HotelBooking("Catalina Hotel", 80, 14));
        bookingList.add(new HotelBooking("Apollo", 200, 6));
        bookingList.add(new HotelBooking("Colonel Hotel", 120, 8));
        bookingList.add(new HotelBooking("Aphrodite", 220, 4));

        return bookingList;
    }
}
