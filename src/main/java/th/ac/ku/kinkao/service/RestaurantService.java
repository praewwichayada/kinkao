package th.ac.ku.kinkao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.kinkao.model.Restaurant;

import java.util.Arrays;
import java.util.List;

@Service
public class RestaurantService { // for database API GET & POST

    @Autowired
    private RestTemplate restTemplate;

    public List<Restaurant> getAll() {
        String url = "http://localhost:8090/restaurant";
        ResponseEntity<Restaurant[]> response = restTemplate.getForEntity(url, Restaurant[].class);
        Restaurant[] restaurants = response.getBody();
        return Arrays.asList(restaurants);
    }

    public void addRestaurant(Restaurant restaurant) {
        String url = "http://localhost:8090/restaurant";
        restTemplate.postForObject(url, restaurant, Restaurant.class);
    }
}
