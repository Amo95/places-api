package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.dto.RestaurantRequest;
import com.services.fetchrestaurantdata.model.Restaurant;

import java.util.List;

public interface RestaurantDataService {

    List<Restaurant> getAllRestaurants();

    Restaurant getByName(String restaurantName);

    Restaurant updateRestaurant(Long id, RestaurantRequest request);

    Restaurant createRestaurant(RestaurantRequest request);

    Restaurant removeRestaurant(Long restaurantId);
}
