package com.service.place.repository;


import com.service.place.model.PlaceData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesApiRepository extends JpaRepository<PlaceData, Long> {
}
