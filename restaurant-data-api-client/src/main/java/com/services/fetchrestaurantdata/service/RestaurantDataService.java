package com.services.fetchrestaurantdata.service;

import com.services.fetchrestaurantdata.dto.RestaurantClientDto;

import java.util.List;

public interface RestaurantDataService {

    List<RestaurantClientDto> getAllRestaurants();
}
