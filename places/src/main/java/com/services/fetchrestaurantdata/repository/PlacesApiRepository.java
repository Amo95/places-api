package com.services.fetchrestaurantdata.repository;


import com.services.fetchrestaurantdata.enums.PlaceType;
import com.services.fetchrestaurantdata.model.PlaceData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesApiRepository extends JpaRepository<PlaceData, Long> {

    List<PlaceData> findByCountry(String country);
    List<PlaceData> findByCountryAndPlaces(String country, PlaceType place);
}
