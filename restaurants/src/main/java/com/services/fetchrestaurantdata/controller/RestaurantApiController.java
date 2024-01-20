package com.services.fetchrestaurantdata.controller;

import com.services.fetchrestaurantdata.dto.RestaurantRequest;
import com.services.fetchrestaurantdata.dto.RestaurantResponse;
import com.services.fetchrestaurantdata.model.Restaurant;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("restaurantName") String restaurantName){
        return ResponseEntity.ok(dataService.getByName(restaurantName));
    }

    @PutMapping("/update/restaurant/{restaurantId}")
    @Operation(summary = "update restaurant to db", description = "update specific restaurant by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<RestaurantResponse> updateRestaurant(@PathVariable("restaurantId") Long id, @Valid @RequestBody RestaurantRequest request) {
        return ResponseEntity.ok(dataService.updateRestaurant(id, request));
    }

    @PostMapping("/add/restaurant/")
    @Operation(summary = "create new restaurant to db", description = "add specific restaurant to db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody RestaurantRequest request) {
        return ResponseEntity.ok(dataService.createRestaurant(request));
    }

    @DeleteMapping("/delete/restaurant/{restaurantId}")
    @Operation(summary = "remove restaurant from db", description = "remove specific restaurant from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long restaurantId){
        return ResponseEntity.ok(dataService.removeRestaurant(restaurantId));
    }
}
