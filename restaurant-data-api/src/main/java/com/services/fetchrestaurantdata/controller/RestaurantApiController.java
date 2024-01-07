package com.services.fetchrestaurantdata.controller;

import com.services.fetchrestaurantdata.model.Restaurant;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(dataService.getAllRestaurants());
    }

    @GetMapping("/{restaurantName}")
    @Operation(summary = "Get a restaurant by name", description = "Returns a single restaurant identified by its name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved restaurant"),
            @ApiResponse(responseCode = "404", description = "cart not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("restaurantName") String restaurantName){
        return ResponseEntity.ok(dataService.getByName(restaurantName));
    }
}
