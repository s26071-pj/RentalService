package com.example.rentalservice.Controller;

import com.example.rentalservice.Model.Rental;
import com.example.rentalservice.Service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;

@RestController("/rental")
public class RentalController {

    public final RentalService rentalService;

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @PutMapping("/rental/{id}/return")
    @Operation(summary = "Return movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Rental.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public Rental returnMovieId(Long id) {
        return this.rentalService.returnMovie(id);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Return movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Rental.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public ResponseEntity<Rental> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rental/{id}/rent")
    @Operation(summary = "Rent a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Rental.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unkown Error",
                    content = @Content)
    })
    public ResponseEntity<Rental> takeMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rental/{id}")
    @Operation(summary = "Rent a movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Rental.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unkown Error",
                    content = @Content)
    })
    public ResponseEntity<Rental> getMovieById(@PathVariable Long id) {
        Rental movie = rentalService.getMovie(id);

        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
