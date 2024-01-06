package com.services.fetchrestaurantdata.repository;


import com.services.fetchrestaurantdata.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantApiRepository extends JpaRepository<Restaurant, Long> {
}
