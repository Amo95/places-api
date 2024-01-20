package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.dto.RestaurantRequest;
import com.services.fetchrestaurantdata.dto.RestaurantResponse;
import com.services.fetchrestaurantdata.model.Restaurant;

import java.util.List;

public interface RestaurantDataService {

    List<Restaurant> getAllRestaurants();

    Restaurant findRestaurant(Long id);

    RestaurantResponse updateRestaurant(Long id, RestaurantRequest request);

    RestaurantResponse createRestaurant(RestaurantRequest request);

    void removeRestaurant(Long restaurantId);
}
