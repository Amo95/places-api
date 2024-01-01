package com.services.restaurantdataapi.restaurant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Restaurant(
        @Id
        String id,
        String name,
        double rating,
        String working_time,
        String phone_number,
        String address,
        @Version
        Integer version
) {
}
