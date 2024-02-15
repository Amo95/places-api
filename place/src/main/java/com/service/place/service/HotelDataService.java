package com.service.place.service;

import com.service.place.dto.Request;
import com.service.place.dto.Response;
import com.service.place.enums.Countries;
import com.service.place.enums.PlaceType;
import com.service.place.model.PlaceData;

import java.util.List;

public interface HotelDataService {
    List<PlaceData> getAllPlaces();

    PlaceData findHotel(Long id);

    Response updateHotel(Long id, Request request);

    Response createRestaurant(Request request);

    void removeRestaurant(Long restaurantId);

    List<PlaceData> getRestaurantByCountry(Countries country);

    List<PlaceData> getAllRestaurantsByPlacesOrCountry(PlaceType placeType, Countries country);
}
