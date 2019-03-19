package com.coen92.projects.web.hotelbookings.control;

import com.coen92.projects.web.hotelbookings.api.BookingRepository;
import com.coen92.projects.web.hotelbookings.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository repository;

    @Autowired
    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAllBookings() {
        return repository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordableBookings(@PathVariable("price") double price) {
        return repository.findByPriceForDayLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> createNewBooking(@RequestBody HotelBooking booking) {
        repository.save(booking);

        return repository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> remove(@PathVariable("id") long id) {
        repository.deleteById(id);

        return repository.findAll();
    }
}
