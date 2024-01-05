package com.services.fetchrestaurantdata.service.Impl;

import com.services.fetchrestaurantdata.dto.RestaurantClientDto;
import com.services.fetchrestaurantdata.repository.RestaurantRepository;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantDataServiceImpl implements RestaurantDataService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantClientDto> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
