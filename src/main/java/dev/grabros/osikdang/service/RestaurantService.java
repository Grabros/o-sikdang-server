package dev.grabros.osikdang.service;

import dev.grabros.osikdang.domain.entity.restaurant.CategoryCode;
import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
import dev.grabros.osikdang.domain.repository.RestaurantGeometryRepository;
import dev.grabros.osikdang.domain.repository.RestaurantRepository;
import dev.grabros.osikdang.web.dto.RestaurantResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantGeometryRepository restaurantGeometryRepository;

    @Transactional(readOnly = true)
    public List<RestaurantResponse> getNearByRestaurants(Coordinate coordinate, Double distance) {
        List<Restaurant> nearByRestaurants = restaurantGeometryRepository
            .getNearByRestaurants(coordinate, distance);
        return nearByRestaurants.stream()
            .map(r -> RestaurantResponse.of(r, coordinate))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestaurantResponse> getNearByRestaurantsByDistrict(String district) {
        Page<Restaurant> restaurants = restaurantRepository
            .findAllByAddressDistrict(district, PageRequest.of(0, 7));
        Coordinate coordinate = new Coordinate(0, 0);
        return restaurants.stream()
            .map(r -> RestaurantResponse.of(r, coordinate))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RestaurantResponse> getCategorizedRestaurantsSortedByRating(String categoryCode, Coordinate coordinate) {
        String category = CategoryCode.getValueOf(categoryCode);
        Page<Restaurant> restaurants = restaurantRepository
            .findAllByCategoryMain(category, getSortedPageRequest(0, 7));
        return restaurants.stream()
            .map(r -> RestaurantResponse.of(r, coordinate))
            .collect(Collectors.toList());
    }

    private PageRequest getSortedPageRequest(int page, int size) {
        Sort sort = Sort.by(Direction.DESC, "rating");
        return PageRequest.of(page, size, sort);
    }
}
