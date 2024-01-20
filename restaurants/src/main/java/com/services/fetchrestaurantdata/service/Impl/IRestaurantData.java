package com.services.fetchrestaurantdata.service.Impl;

import com.services.fetchrestaurantdata.dto.RestaurantRequest;
import com.services.fetchrestaurantdata.dto.RestaurantResponse;
import com.services.fetchrestaurantdata.exceptions.NotFoundException;
import com.services.fetchrestaurantdata.model.Restaurant;
import com.services.fetchrestaurantdata.repository.RestaurantApiRepository;
import com.services.fetchrestaurantdata.service.RestaurantDataService;
import com.services.fetchrestaurantdata.util.BasicMapper;
import com.services.fetchrestaurantdata.util.UpdatingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IRestaurantData implements RestaurantDataService {

    private final RestaurantApiRepository restaurantRepository;
    private final BasicMapper basicMapper;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurant(Long id) {
        return getRestaurant(id);
    }

    @Override
    public RestaurantResponse updateRestaurant(Long id, RestaurantRequest request) {
        Restaurant restaurant = basicMapper.convertTo(request, Restaurant.class);
        return basicMapper.convertTo(updateRestaurant(id, restaurant), RestaurantResponse.class);
    }

    private Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Shipping address not found"));
    }

    private Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant restaurantData = getRestaurant(id);
        BeanUtils.copyProperties(restaurant, restaurantData, UpdatingUtil.getNullPropertyNames(restaurant));
        return restaurantRepository.save(restaurantData);
    }

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {
        Restaurant restaurant = basicMapper.convertTo(request, Restaurant.class);
        return basicMapper.convertTo(addRestaurant(restaurant), RestaurantResponse.class);
    }

    private Object addRestaurant(Restaurant restaurant) {

        Restaurant restaurant1 = Restaurant.builder()
                .name(restaurant.getName())
                .rating(restaurant.getRating())
                .working_time(restaurant.getWorking_time())
                .phone_number(restaurant.getPhone_number())
                .address(restaurant.getAddress())
                .build();
        return restaurantRepository.save(restaurant1);
    }

    @Override
    public void removeRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }
}