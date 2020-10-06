package dev.grabros.osikdang.service;

import dev.grabros.osikdang.domain.restaurant.Restaurant;
import dev.grabros.osikdang.geometry.Direction;
import dev.grabros.osikdang.geometry.GeometryUtil;
import dev.grabros.osikdang.geometry.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final EntityManager em;

    @Transactional(readOnly = true)
    public List<Restaurant> getNearByRestaurants(Double latitude, Double longitude, Double distance) {
        Location northEast = GeometryUtil
            .calculate(latitude, longitude, distance, Direction.NORTHEAST.getBearing());
        Location southWest = GeometryUtil
            .calculate(latitude, longitude, distance, Direction.SOUTHWEST.getBearing());

        double x1 = northEast.getLatitude();
        double y1 = northEast.getLongitude();
        double x2 = southWest.getLatitude();
        double y2 = southWest.getLongitude();

        String pointFormat = String.format("'LINESTRING(%f %f, %f %f)')", x1, y1, x2, y2);
        Query query = em.createNativeQuery("SELECT r.id, r.address, r.address_city, "
                + "r.address_district, r.address_district_old, r.address_old, r.address_province, "
                + "r.category, r.category_code, r.category_industry, r.category_main, r.category_sub, "
                + "r.point, r.name, r.zip_code "
                + "FROM restaurant AS r "
                + "WHERE MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + ", r.point)", Restaurant.class)
            .setMaxResults(10);

        List<Restaurant> restaurants = query.getResultList();
        return restaurants;
    }
}
