package dev.grabros.osikdang;

import dev.grabros.osikdang.domain.restaurant.Restaurant;
import dev.grabros.osikdang.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Restaurant restaurant = new Restaurant();
//        restaurantRepository.save(restaurant);
    }
}
