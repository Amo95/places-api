package com.service.place.model;

import com.service.place.enums.Countries;
import com.service.place.enums.PlaceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.Version;

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
    Countries country;
    PlaceType places;
    @Version
    Integer version;
}
