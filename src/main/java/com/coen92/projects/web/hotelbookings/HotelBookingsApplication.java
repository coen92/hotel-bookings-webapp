package com.coen92.projects.web.hotelbookings;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class HotelBookingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingsApplication.class, args);
    }

}
