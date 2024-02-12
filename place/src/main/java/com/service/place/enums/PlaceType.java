package com.service.place.enums;

import lombok.Getter;

import static com.service.place.constants.PlaceConstants.*;

@Getter
public enum PlaceType {

    RESTAURANTS(RESTAURANT_VENUE),
    HOTELS(HOTEL_VENUE),
    SCHOOLS(SCHOOL_VENUE);

    private final String place;

    PlaceType(String place) {
        this.place = place;
    }
}
