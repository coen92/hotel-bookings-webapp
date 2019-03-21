package com.coen92.projects.web.hotelbookings.control;

import com.coen92.projects.web.hotelbookings.api.BookingRepository;
import com.coen92.projects.web.hotelbookings.model.HotelBooking;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Hotel Booking API", description = "List of methods for hotel bookings management", stage = ApiStage.RC)
public class BookingController {

    private BookingRepository repository;

    @Autowired
    public BookingController(BookingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Getting list of all bookings stored in database")
    public List<HotelBooking> getAllBookings() {
        return repository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Getting list of hotel bookings where the price for a day is less than the provided value")
    public List<HotelBooking> getAffordableBookings(@ApiPathParam(name = "price") @PathVariable("price") double price) {
        return repository.findByPriceForDayLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Creating a new hotel booking and storing it in database")
    public List<HotelBooking> createNewBooking(@RequestBody HotelBooking booking) {
        repository.save(booking);

        return repository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Deleting the hotel booking with provided ID from the database")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable("id") long id) {
        repository.deleteById(id);

        return repository.findAll();
    }
}
