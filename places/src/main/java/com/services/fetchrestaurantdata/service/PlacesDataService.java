package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.dto.Request;
import com.services.fetchrestaurantdata.dto.Response;
import com.services.fetchrestaurantdata.enums.PlaceType;
import com.services.fetchrestaurantdata.model.PlaceData;

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
