package com.services.restaurantdataapi.restaurant;

import org.springframework.data.repository.ListCrudRepository;

public interface RestaurantRepository extends ListCrudRepository<Restaurant, String> {
}
