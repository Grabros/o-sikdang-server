package dev.grabros.osikdang.domain.repository;

import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Page<Restaurant> findAllByCategoryMain(String category, Pageable pageable);

    @Query(value = "SELECT * FROM restaurant AS r WHERE r.address_district = :district ORDER BY RAND()", nativeQuery = true)
    Page<Restaurant> findAllByAddressDistrict(@Param("district") String district, Pageable pageable);
}
