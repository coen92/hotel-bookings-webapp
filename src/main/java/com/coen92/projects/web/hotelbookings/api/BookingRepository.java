package com.coen92.projects.web.hotelbookings.api;

import com.coen92.projects.web.hotelbookings.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByPriceForDayLessThan(double price);
}
