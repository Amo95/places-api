package com.services.persistrestaurantdata;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.persistrestaurantdata.restaurant.model.RestaurantEntity;
import com.services.persistrestaurantdata.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
    private final RestaurantRepository restaurantRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) {
        List<RestaurantEntity> restaurantsInfo = new ArrayList<>();
        JsonNode jsonNode;

        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/restaurants.json")) {
            jsonNode = objectMapper.readValue(inputStream, JsonNode.class);
        } catch (IOException ioException) {
            throw new RuntimeException("Failed to read json data", ioException);
        }

        JsonNode restaurants = getRestaurants(jsonNode);
        for(JsonNode restaurant: restaurants) {
            restaurantsInfo.add(createRestaurantInfoNode(restaurant));
        }


        if (isNewRestaurantData(restaurantsInfo)) {
            restaurantRepository.saveAll(restaurantsInfo);
        } else {
            LOGGER.warn("Data already exists!");
        }
    }

    private boolean isNewRestaurantData(List<RestaurantEntity> restaurantsInfo) {
        List<RestaurantEntity> existingRestaurants = restaurantRepository.findAll();
        return !(
                existingRestaurants
                        .isEmpty() || !new HashSet<>(existingRestaurants)
                        .containsAll(restaurantsInfo));
    }

    private RestaurantEntity createRestaurantInfoNode(JsonNode restaurant) {
        String name =  restaurant.get("name").asText();
        double rating = restaurant.get("rating").asDouble();
        String workingTime = restaurant.get("workday_timing").asText();
        String phoneNumber = restaurant.get("phone").asText();
        String address = restaurant.get("address").asText();

        return RestaurantEntity.builder()
                .name(name)
                .rating(rating)
                .working_time(workingTime)
                .phone_number(phoneNumber)
                .address(address)
                .build();
    }

    private JsonNode getRestaurants(JsonNode jsonNode) {
        return Optional.ofNullable(jsonNode)
                .map(j -> j.get("restaurants"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid JSON Object"));
    }
}
