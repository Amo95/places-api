package com.services.fetchrestaurantdata.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class RestaurantResponse {
    Long id;
    String name;
    double rating;
    String working_time;
    String phone_number;
    String address;
}
