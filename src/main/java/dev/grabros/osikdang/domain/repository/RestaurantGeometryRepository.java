package dev.grabros.osikdang.domain.repository;

import dev.grabros.osikdang.domain.entity.restaurant.Restaurant;
import dev.grabros.osikdang.global.util.geometry.Direction;
import dev.grabros.osikdang.global.util.geometry.GeometryUtil;
import dev.grabros.osikdang.global.util.geometry.Location;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantGeometryRepository {

    @PersistenceContext
    private EntityManager em;

    /**
     * distance unit : km
     * x : latitude - 127.xxx
     * y : longitude - 37.xxx
     */
    public List<Restaurant> getNearByRestaurants(Coordinate coordinate, Double distance) {
        Location northEast = GeometryUtil
            .calculate(coordinate.y, coordinate.x, distance, Direction.NORTHEAST.getBearing());
        Location southWest = GeometryUtil
            .calculate(coordinate.y, coordinate.x, distance, Direction.SOUTHWEST.getBearing());

        double x1 = northEast.getLongitude();
        double y1 = northEast.getLatitude();
        double x2 = southWest.getLongitude();
        double y2 = southWest.getLatitude();

        String pointFormat = String.format("'LINESTRING(%f %f, %f %f)')", x1, y1, x2, y2);
        Query query = em.createNativeQuery("SELECT r.id, r.address, r.address_city, "
            + "r.address_district, r.address_district_old, r.address_old, r.address_province, "
            + "r.category, r.category_code, r.category_industry, r.category_main, r.category_sub, "
            + "r.point, r.name, r.zip_code, r.rating "
            + "FROM restaurant AS r "
            + "WHERE MBRContains(ST_LINESTRINGFROMTEXT(" + pointFormat + ", r.point) "
            + "ORDER BY RAND()", Restaurant.class)
            .setMaxResults(10);

        List<Restaurant> restaurants = query.getResultList();
        return restaurants;
    }
}
