package com.service.place.service.Impl;

import com.service.place.dto.Request;
import com.service.place.dto.Response;
import com.service.place.enums.PlaceType;
import com.service.place.model.PlaceData;
import com.service.place.repository.PlacesApiRepository;
import com.service.place.service.PlacesDataService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPlacesData implements PlacesDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPlacesData.class);
    private final PlacesApiRepository placesApiRepository;

    @Override
    public List<PlaceData> getAllPlaces() {
        LOGGER.info(String.format("data fetched from db => %s", placesApiRepository.findAll());
        return placesApiRepository.findAll();
    }

    @Override
    public PlaceData findRestaurant(Long id) {
        return null;
    }

    @Override
    public Response updateRestaurant(Long id, Request request) {
        return null;
    }

    @Override
    public Response createRestaurant(Request request) {
        return null;
    }

    @Override
    public void removeRestaurant(Long restaurantId) {

    }

    @Override
    public List<PlaceData> getRestaurantByCountry(String country) {
        return List.of();
    }

    @Override
    public List<PlaceData> getAllRestaurantsByPlacesOrCountry(PlaceType placeType, String country) {
        return List.of();
    }
}

