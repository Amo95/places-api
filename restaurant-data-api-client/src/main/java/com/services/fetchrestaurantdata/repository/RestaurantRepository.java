package com.services.fetchrestaurantdata.repository;


import com.services.fetchrestaurantdata.dto.RestaurantClientDto;
import com.services.fetchrestaurantdata.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("restaurantRepo")
public interface RestaurantRepository extends JpaRepository<RestaurantClientDto, Long> {
}
