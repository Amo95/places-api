package com.services.fetchrestaurantdata.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "restaurant_entity")
@Getter
@Setter
@Builder
public class PlaceData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    double rating;
    String working_time;
    String phone_number;
    String address;
    String country;
    @Version
    Integer version;
}
