package com.services.persistrestaurantdata.restaurant.repository;

import com.services.persistrestaurantdata.restaurant.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
