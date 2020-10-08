package dev.grabros.osikdang.web.controller;

import dev.grabros.osikdang.service.RestaurantService;
import dev.grabros.osikdang.web.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/{category}")
    public ResponseEntity<RestaurantResponse> viewCategorizedRestaurantsSortedByRating(
        @PathVariable String category) {
        return new ResponseEntity(
            restaurantService.getCategorizedRestaurantsSortedByRating(category), HttpStatus.OK);
    }
}
