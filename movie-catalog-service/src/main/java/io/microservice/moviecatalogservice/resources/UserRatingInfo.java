package io.microservice.moviecatalogservice.resources;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.microservice.moviecatalogservice.models.RatingInfo;
import io.microservice.moviecatalogservice.models.UserRatings;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate template;

	@HystrixCommand(fallbackMethod = "getFallbackUserRatingData", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			   @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			   @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")})
	public UserRatings getUserRatingData(@PathVariable("userId") String userId) {
		UserRatings ratings = template.getForObject("http://RATING-DATA-SERVICE/ratings/userRatings/" + userId,
				UserRatings.class);
		return ratings;
	}

	public UserRatings getFallbackUserRatingData(@PathVariable("userId") String userId) {
		UserRatings ratings = new UserRatings();
		ratings.setUserId(userId);
		ratings.setRatings(Arrays.asList(new RatingInfo("0", 0)));
		return ratings;
	}
}
