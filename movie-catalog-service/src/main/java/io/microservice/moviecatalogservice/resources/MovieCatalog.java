package io.microservice.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.microservice.moviecatalogservice.models.CatalogItem;
import io.microservice.moviecatalogservice.models.MovieInfo;
import io.microservice.moviecatalogservice.models.RatingInfo;
import io.microservice.moviecatalogservice.models.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalog {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private DiscoveryClient discoveryClient; //for advanced load balancing on your own but not recommended
	
	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@Autowired
	private UserRatingInfo userRatingInfo;
	
	@Autowired
	private MovieInformation movieInformation;
	
	@RequestMapping("/{userId}")
	//@HystrixCommand(fallbackMethod = "getFallbackMovieCatalog")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId) {
		/*
		 * List<CatalogItem> list = new ArrayList<CatalogItem>();
		 * CatalogItem item = new CatalogItem("gaurav1", "transformer", 5); 
		 * list.add(item); 
		 * return list;
		 */
		//RestTemplate template = new RestTemplate();
		
		//1. get the list of movies
		
		//2. get the movie info for each movie
		
		//3. consolidate both data and return
		
		//step 1 - hard code it for now and create list of ratings model
		/*
		 * List<RatingInfo> ratings = Arrays.asList( new RatingInfo("movie01", 5), new
		 * RatingInfo("movie02", 7));
		 */
		
		UserRatings ratings = userRatingInfo.getUserRatingData(userId);
		//step 2 - 
		
		/*return ratings.stream().map(rating -> {
			MovieInfo movieInfo = template.getForObject("http://localhost:8082/movies/" + rating.getMoviedId(), MovieInfo.class);*/
		return ratings.getRatings().stream().map(rating -> {
			
			//MovieInfo movieInfo = webclientBuilder.build().get().uri("http://localhost:8082/movies/" + rating.getMoviedId()).retrieve().bodyToMono(MovieInfo.class).block();
			MovieInfo movieInfo = movieInformation.getMovieInfo(rating.getMoviedId());
			return new CatalogItem(userId, movieInfo.getMovieDescription(), rating.getRating());
		}).collect(Collectors.toList());
		//return Collections.singletonList(new CatalogItem("gaurav1", "transformer", 5));
		
	}
	
	
	
	
	/*
	 * public List<CatalogItem> getFallbackMovieCatalog(@PathVariable("userId")
	 * String userId) { return Collections.singletonList(new CatalogItem("gaurav1",
	 * "transformer", 5)); }
	 */
}
