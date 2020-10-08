package dev.grabros.osikdang;

import dev.grabros.osikdang.domain.restaurant.Restaurant;
import dev.grabros.osikdang.service.RestaurantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    RestaurantService restaurantService;

    @Transactional(readOnly = true)
    @Override
    public void run(ApplicationArguments args) {
        final List<Restaurant> nearRestaurants = restaurantService
            .getNearByRestaurants(37.4901548250937, 127.030767490957, 0.1);

        for (Restaurant restaurant : nearRestaurants) {
            System.out.println(
                restaurant.getName() + " / " + restaurant.getCategorySub() + " / " + restaurant
                    .getAddressOld() + " / " + restaurant.getPoint());
        }
    }
}
