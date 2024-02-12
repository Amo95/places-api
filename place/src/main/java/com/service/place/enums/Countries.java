package com.service.place.enums;

import lombok.Getter;

import static com.service.place.constants.CountryConstants.*;

@Getter
public enum Countries {
    GHANA(GHANA_STATE),
    NIGERIA(NIGERIA_STATE),
    IVORY_COAST(IVORY_COAST_STATE),
    UNITED_STATES(UNITED_STATES_STATE);

    private final String country;

    Countries(String country) {
        this.country = country;
    }
}
