package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.model.Restaurant;

import java.util.List;

public interface RestaurantDataService {

    List<Restaurant> getAllRestaurants();
}
