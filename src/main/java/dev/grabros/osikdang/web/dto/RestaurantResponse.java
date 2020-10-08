package dev.grabros.osikdang.web.dto;

import dev.grabros.osikdang.domain.restaurant.Restaurant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RestaurantResponse {

    private Long id;
    private String name;
    private String categoryMain;
    private String categorySub;
    private String address;
    private Float rating;

    @Builder
    public RestaurantResponse(Long id, String name, String categoryMain, String categorySub,
        String address, Float rating) {
        this.id = id;
        this.name = name;
        this.categoryMain = categoryMain;
        this.categorySub = categorySub;
        this.address = address;
        this.rating = rating;
    }

    public static RestaurantResponse of(Restaurant restaurant) {
        return RestaurantResponse.builder()
            .id(restaurant.getId())
            .name(restaurant.getName())
            .categoryMain(restaurant.getCategoryMain())
            .categorySub(restaurant.getCategorySub())
            .address(restaurant.getAddress())
            .rating(0.0f)
            .build();
    }
}
