package com.service.place.api;

import com.services.fetchrestaurantdata.dto.Request;
import com.services.fetchrestaurantdata.dto.Response;
import com.services.fetchrestaurantdata.enums.PlaceType;
import com.services.fetchrestaurantdata.model.PlaceData;
import com.services.fetchrestaurantdata.service.PlacesDataService;
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
@RequestMapping("/api/v1/restaurants-data")
@RequiredArgsConstructor
public class PlacesApiController {

    private final PlacesDataService dataService;

    @GetMapping("/all/restaurants")
    @Operation(summary = "fetch all restaurants from db", description = "fetch restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched restaurant data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<List<PlaceData>> findAll() {
        return ResponseEntity.ok(dataService.getAllPlaces());
    }

    @GetMapping("/all/{places}/{country}")
    @Operation(summary = "fetch data by type of place and country", description = "fetch restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched restaurant data"),
            @ApiResponse(responseCode = "500", description = "Internal server error occurred")
    })
    public ResponseEntity<List<PlaceData>> fetchPlaceData(@PathVariable("places") PlaceType placeType, @PathVariable("country") String country) {
        return ResponseEntity.ok(dataService.getAllRestaurantsByPlacesOrCountry(placeType, country));
    }

    @GetMapping("/restaurant/{id}")
    @Operation(summary = "Get a restaurant by id", description = "Returns a single restaurant identified by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PlaceData> fetchRestaurant(@PathVariable("id") Long id){
        return ResponseEntity.ok(dataService.findRestaurant(id));
    }

    @PutMapping("/update/restaurant/{restaurantId}")
    @Operation(summary = "update restaurant to db", description = "update specific restaurant by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated restaurant"),
            @ApiResponse(responseCode = "404", description = "restaurant not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Response> updateRestaurant(@PathVariable("restaurantId") Long id, @Valid @RequestBody Request request) {
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
    public ResponseEntity<List<PlaceData>> fetchRestaurantByCountry(@PathVariable String country){
        return ResponseEntity.ok(dataService.getRestaurantByCountry(country));
    }
}
