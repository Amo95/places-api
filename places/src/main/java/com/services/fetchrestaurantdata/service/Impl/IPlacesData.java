package com.services.fetchrestaurantdata.service.Impl;

import com.services.fetchrestaurantdata.dto.Request;
import com.services.fetchrestaurantdata.dto.Response;
import com.services.fetchrestaurantdata.exceptions.NotFoundException;
import com.services.fetchrestaurantdata.model.PlaceData;
import com.services.fetchrestaurantdata.repository.PlacesApiRepository;
import com.services.fetchrestaurantdata.service.PlacesDataService;
import com.services.fetchrestaurantdata.util.BasicMapper;
import com.services.fetchrestaurantdata.util.UpdatingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPlacesData implements PlacesDataService {

    private final PlacesApiRepository restaurantRepository;
    private final BasicMapper basicMapper;

    @Override
    public List<PlaceData> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public PlaceData findRestaurant(Long id) {
        return getRestaurant(id);
    }

    @Override
    public Response updateRestaurant(Long id, Request request) {
        PlaceData restaurant = basicMapper.convertTo(request, PlaceData.class);
        return basicMapper.convertTo(updateRestaurant(id, restaurant), Response.class);
    }

    @Override
    public Response createRestaurant(Request request) {
        PlaceData restaurant = basicMapper.convertTo(request, PlaceData.class);
        return basicMapper.convertTo(addRestaurant(restaurant), Response.class);
    }

    @Override
    public void removeRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public List<PlaceData> getRestaurantByCountry(String country) {
        return basicMapper.convertListTo(restaurantRepository.findByCountry(country),
                PlaceData.class);
    }

    private PlaceData getRestaurant(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Shipping address not found"));
    }

    private PlaceData updateRestaurant(Long id, PlaceData restaurant) {
        PlaceData restaurantData = getRestaurant(id);
        BeanUtils.copyProperties(restaurant, restaurantData, UpdatingUtil.getNullPropertyNames(restaurant));
        return restaurantRepository.save(restaurantData);
    }

    private PlaceData addRestaurant(PlaceData restaurant) {

        PlaceData restaurant1 = PlaceData.builder()
                .name(restaurant.getName())
                .rating(restaurant.getRating())
                .working_time(restaurant.getWorking_time())
                .phone_number(restaurant.getPhone_number())
                .address(restaurant.getAddress())
                .country(restaurant.getCountry())
                .build();
        return restaurantRepository.save(restaurant1);
    }
}

