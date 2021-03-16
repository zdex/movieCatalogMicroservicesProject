package io.microservice.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.microservice.moviecatalogservice.models.MovieInfo;

@Service
public class MovieInformation {

	@Autowired
	private RestTemplate template;

	@HystrixCommand(fallbackMethod = "getFallbackMovieInfo", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			   @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			   @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			   @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")})
	public MovieInfo getMovieInfo(String moviedId) {
		MovieInfo movieInfo = template.getForObject("http://MOVIE-INFO-SERVICE/movies/" + moviedId, MovieInfo.class);
		return movieInfo;
	}

	public MovieInfo getFallbackMovieInfo(String moviedId) {
		MovieInfo movieInfo = new MovieInfo("movieId", "movieName", "movieDescription");
		return movieInfo;
	}
}
