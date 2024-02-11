package com.service.place.service.Impl;

import com.service.place.dto.Request;
import com.service.place.dto.Response;
import com.service.place.enums.PlaceType;
import com.service.place.exceptions.NotFoundException;
import com.service.place.model.PlaceData;
import com.service.place.repository.PlacesApiRepository;
import com.service.place.service.PlacesDataService;
import com.service.place.util.BasicMapper;
import com.service.place.util.UpdatingUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IPlacesData implements PlacesDataService {

    private final PlacesApiRepository placesApiRepository;
    private final BasicMapper basicMapper;

    @Override
    public List<PlaceData> getAllPlaces() {
        return placesApiRepository.findAll();
    }

    @Override
    public PlaceData findRestaurant(Long id) {
        return getPlaceData(id);
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
        placesApiRepository.deleteById(restaurantId);
    }

    @Override
    public List<PlaceData> getRestaurantByCountry(String country) {
        return basicMapper.convertListTo(placesApiRepository.findByCountry(country),
                PlaceData.class);
    }

    @Override
    public List<PlaceData> getAllRestaurantsByPlacesOrCountry(PlaceType placeType, String country) {
        return basicMapper.convertListTo(placesApiRepository.findByCountryAndPlaces(country, placeType),
                PlaceData.class);
    }

    private PlaceData getPlaceData(Long id) {
        return placesApiRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("place not found"));
    }

    private PlaceData updateRestaurant(Long id, PlaceData data) {
        PlaceData placeData = getPlaceData(id);
        BeanUtils.copyProperties(data, placeData, UpdatingUtil.getNullPropertyNames(data));
        return placesApiRepository.save(placeData);
    }

    private PlaceData addRestaurant(PlaceData data) {

        PlaceData placeData = PlaceData.builder()
                .name(data.getName())
                .rating(data.getRating())
                .working_time(data.getWorking_time())
                .phone_number(data.getPhone_number())
                .address(data.getAddress())
                .country(data.getCountry())
                .places(data.getPlaces())
                .build();
        return placesApiRepository.save(placeData);
    }
}
