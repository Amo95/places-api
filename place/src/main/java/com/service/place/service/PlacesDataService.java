package com.service.place.service;

import com.service.place.dto.Request;
import com.service.place.dto.Response;
import com.service.place.enums.PlaceType;
import com.service.place.model.PlaceData;

import java.util.List;

public interface PlacesDataService {

    List<PlaceData> getAllPlaces();

    PlaceData findRestaurant(Long id);

    Response updateRestaurant(Long id, Request request);

    Response createRestaurant(Request request);

    void removeRestaurant(Long restaurantId);

    List<PlaceData> getRestaurantByCountry(String country);

    List<PlaceData> getAllRestaurantsByPlacesOrCountry(PlaceType placeType, String country);
}
