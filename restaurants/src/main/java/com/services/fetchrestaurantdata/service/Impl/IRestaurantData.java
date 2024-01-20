package com.services.fetchrestaurantdata.service.Impl;

import com.services.fetchrestaurantdata.dto.RestaurantRequest;
import com.services.fetchrestaurantdata.model.Restaurant;
import com.services.fetchrestaurantdata.repository.RestaurantApiRepository;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IRestaurantData implements RestaurantDataService {

    private final RestaurantApiRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getByName(String restaurantName) {
        return restaurantRepository.findByName(restaurantName);
    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantRequest request) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(RestaurantRequest request) {
        return null;
    }

    @Override
    public Restaurant removeRestaurant(Long restaurantId) {
        return null;
    }
}
