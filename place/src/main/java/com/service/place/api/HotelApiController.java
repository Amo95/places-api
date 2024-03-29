package com.service.place.api;

import com.service.place.dto.Request;
import com.service.place.dto.Response;
import com.service.place.enums.Countries;
import com.service.place.enums.PlaceType;
import com.service.place.model.PlaceData;
import com.service.place.service.RestaurantDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels-data")
@RequiredArgsConstructor
public class HotelApiController {

    private final RestaurantDataService dataService;

    @GetMapping("/all/hotels")
    @Operation(summary = "fetch all hotels from db", description = "fetch hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched hotels data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<List<PlaceData>> findAll() {
        return ResponseEntity.ok(dataService.getAllPlaces());
    }

    @GetMapping("/all/{places}/{country}")
    @Operation(summary = "fetch data by type of place and country", description = "fetch hotels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched hotels data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<List<PlaceData>> fetchPlaceData(@PathVariable("places") PlaceType placeType, @PathVariable("country") Countries country) {
        return ResponseEntity.ok(dataService.getAllRestaurantsByPlacesOrCountry(placeType, country));
    }

    @GetMapping("/hotel/{id}")
    @Operation(summary = "Get a hotel by id", description = "Returns a single hotel identified by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved hotel"),
            @ApiResponse(responseCode = "404", description = "hotel not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PlaceData> fetchRestaurant(@PathVariable("id") Long id){
        return ResponseEntity.ok(dataService.findRestaurant(id));
    }

    @PutMapping("/update/hotel/{hotelId}")
    @Operation(summary = "update restaurant to db", description = "update specific restaurant by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Response> updateRestaurant(@PathVariable("hotelId") Long id, @Valid @RequestBody Request request) {
        return ResponseEntity.ok(dataService.updateRestaurant(id, request));
    }

    @PostMapping("/add/restaurant/")
    @Operation(summary = "create new restaurant to db", description = "add specific restaurant to db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Response> addRestaurant(@RequestBody Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dataService.createRestaurant(request));
    }

    @DeleteMapping("/delete/restaurant/{restaurantId}")
    @Operation(summary = "remove restaurant from db", description = "remove specific restaurant from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long restaurantId){
        dataService.removeRestaurant(restaurantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{country}/restaurants")
    @Operation(summary = "get restaurants by country", description = "filter restaurants by country")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully filtered restaurant"),
            @ApiResponse(responseCode = "404", description = "country not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<PlaceData>> fetchRestaurantByCountry(@PathVariable Countries country){
        return ResponseEntity.ok(dataService.getRestaurantByCountry(country));
    }
}
