package com.services.persistrestaurantdata.restaurant.repository;

import com.services.persistrestaurantdata.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("restaurantRepo")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
