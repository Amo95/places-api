package com.service.place.repository;


import com.service.place.enums.Countries;
import com.service.place.enums.PlaceType;
import com.service.place.model.PlaceData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesApiRepository extends JpaRepository<PlaceData, Long> {
    List<Object> findByCountry(Countries country);
    List<Object> findByPlacesAndCountry(PlaceType type, Countries countries);
}
