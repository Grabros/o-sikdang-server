package dev.grabros.osikdang.domain.repository;

import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Page<Restaurant> findAllByCategoryMain(String category, Pageable pageable);

    Page<Restaurant> findAllByAddressDistrict(String district, Pageable pageable);
}
