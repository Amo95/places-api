package com.services.persistrestaurantdata.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    double rating;
    String working_time;
    String phone_number;
    String address;
    @Version
    Integer version;
}
