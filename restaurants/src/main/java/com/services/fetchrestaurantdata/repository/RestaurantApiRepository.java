package com.services.fetchrestaurantdata.repository;


import com.services.fetchrestaurantdata.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantApiRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByCountry(String country);
}
