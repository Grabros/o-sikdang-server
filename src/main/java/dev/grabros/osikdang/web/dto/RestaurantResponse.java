package dev.grabros.osikdang.web.dto;

import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
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
    private Double rating;
    private int ratingCount;
    private Double distance;
    private String image;

    @Builder
    public RestaurantResponse(Long id, String name, String categoryMain, Double rating, int ratingCount,
        Double distance, String image) {
        this.id = id;
        this.name = name;
        this.categoryMain = categoryMain;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.distance = distance;
        this.image = image;
    }

    public static RestaurantResponse of(Restaurant restaurant) {
        return RestaurantResponse.builder()
            .id(restaurant.getId())
            .name(restaurant.getName())
            .categoryMain(restaurant.getCategoryMain())
            .rating(restaurant.getRating())
            .ratingCount(restaurant.getReviews().size())
            .distance(0.0)
            .image(null)
            .build();
    }
}
