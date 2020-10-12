package dev.grabros.osikdang.domain.repository;

import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByCategoryMain(String category);
}
