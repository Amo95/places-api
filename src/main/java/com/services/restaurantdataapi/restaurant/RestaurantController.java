package com.services.restaurantdataapi.restaurant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @GetMapping("/all/restaurants")
    @Operation(summary = "fetch all restaurants from db", description = "fetch restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched restaurant data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(restaurantRepository.findAll());
    }
}
