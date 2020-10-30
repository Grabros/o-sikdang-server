package dev.grabros.osikdang.web.controller;

import dev.grabros.osikdang.service.RestaurantService;
import dev.grabros.osikdang.web.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity<RestaurantResponse> viewNearByRestaurants(
        @RequestParam(value = "distance", required = false, defaultValue = "300") Double distance,
        @RequestParam(value = "x", required = false, defaultValue = "0") Double x,
        @RequestParam(value = "y", required = false, defaultValue = "0") Double y) {

        return new ResponseEntity(
            restaurantService.getNearByRestaurants(new Coordinate(x, y), distance), HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<RestaurantResponse> viewCategorizedRestaurantsSortedByRating(
        @PathVariable String category,
        @RequestParam(value = "x", required = false, defaultValue = "0") Double x,
        @RequestParam(value = "y", required = false, defaultValue = "0") Double y) {

        return new ResponseEntity(
            restaurantService.getCategorizedRestaurantsSortedByRating(category, new Coordinate(x, y)), HttpStatus.OK);
    }
}
