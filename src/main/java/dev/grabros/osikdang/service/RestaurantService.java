package dev.grabros.osikdang.service;

import dev.grabros.osikdang.domain.restaurant.Restaurant;
import dev.grabros.osikdang.repository.RestaurantGeometryRepository;
import dev.grabros.osikdang.repository.RestaurantRepository;
import dev.grabros.osikdang.web.dto.RestaurantResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantGeometryRepository restaurantGeometryRepository;

    @Transactional(readOnly = true)
    public List<Restaurant> getNearByRestaurants(Double latitude, Double longitude, Double distance) {
        List<Restaurant> nearByRestaurants = restaurantGeometryRepository.getNearByRestaurants(latitude, longitude, distance);
        return nearByRestaurants;
//        return nearByRestaurants.stream().map(r -> RestaurantResponse.of(r)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestaurantResponse> getCategorizedRestaurantsSortedByRating(String category) {
        List<Restaurant> restaurants = restaurantRepository.findAllByCategoryMain(category);
        return restaurants.stream().map(r -> RestaurantResponse.of(r)).collect(Collectors.toList());
    }
}
