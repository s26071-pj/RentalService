package com.example.rentalservice.Controller;

import com.example.rentalservice.Model.Rental;
import com.example.rentalservice.Service.RentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/rental")
public class RentalController {

    public final RentalService rentalService;

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

//    @GetMapping
//
//    @PutMapping
//
}
