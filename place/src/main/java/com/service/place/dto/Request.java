package com.service.place.dto;

import com.service.place.enums.Countries;
import com.service.place.enums.PlaceType;
import lombok.*;

@Data
public class Request {
    String name;
    double rating;
    String working_time;
    String phone_number;
    String address;
    Countries country;
    PlaceType place;
}
