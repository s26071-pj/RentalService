package com.example.rentalservice.Service;

import com.example.rentalservice.Model.Rental;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Rental getMovie(Long id) {
        Rental forObject = this.restTemplate.getForObject("https://localhost:8080/movies/{id}", Rental.class, id);
        return forObject;

    }

    public Rental returnMovie(Long id) {
        Rental forObject = this.restTemplate.getForObject("https://localhost:8080/isAvaiable/{id}", Rental.class, id);
        return forObject;
    }

    public void rentMovie(Long id) {
        restTemplate.put("http://localhost:8080/movies/{id}/set_available/false", HttpEntity.EMPTY, id);
    }
}