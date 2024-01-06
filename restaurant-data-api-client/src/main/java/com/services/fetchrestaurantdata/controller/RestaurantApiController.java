package com.services.fetchrestaurantdata.controller;

import com.services.fetchrestaurantdata.model.Restaurant;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
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
@RequestMapping("/api/v1/restaurants-data")
@RequiredArgsConstructor
public class RestaurantApiController {

    private final RestaurantDataService dataService;

    @GetMapping("/all/restaurants")
    @Operation(summary = "fetch all restaurants from db", description = "fetch restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched restaurant data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(dataService.getAllRestaurants());
    }
}
