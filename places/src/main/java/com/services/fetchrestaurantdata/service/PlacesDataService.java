package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.dto.Request;
import com.services.fetchrestaurantdata.dto.Response;
import com.services.fetchrestaurantdata.model.PlaceData;

import java.util.List;

public interface PlacesDataService {

    List<PlaceData> getAllRestaurants();

    PlaceData findRestaurant(Long id);

    Response updateRestaurant(Long id, Request request);

    Response createRestaurant(Request request);

    void removeRestaurant(Long restaurantId);

    List<PlaceData> getRestaurantByCountry(String country);
}
