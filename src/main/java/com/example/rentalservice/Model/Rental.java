package com.example.rentalservice.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Schema(title="Rental", name="rental", description = "")
public class Rental {
    @Schema(description = "Identity number of movie")
    private Long id;
    @Schema(description = "Name of movie")
    @Size(min = 0, max = 50)
    private String name;
    @Schema(description = "Category of Movie")
    @NotNull
    private String category;


    @Schema(description = "Checking if rented movie status is available")
    @NotNull
    private boolean isAvailable = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
