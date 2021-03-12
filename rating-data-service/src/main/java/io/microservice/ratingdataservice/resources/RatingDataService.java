package io.microservice.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservice.ratingdataservice.model.RatingInfo;

@RestController
@RequestMapping("/ratings")
public class RatingDataService {

	@RequestMapping("{movieId}")
	public RatingInfo getMovieRatingInfo(@PathVariable("movieId") String movieId) {		
		return new RatingInfo("movie01", 5);
	} 
	
	@RequestMapping("users/{userId}")
	public List<RatingInfo> getUserRatingInfo(@PathVariable("userId") String userId) {	
		return Arrays.asList(new RatingInfo("movie01", 5),
				new RatingInfo("movie02", 7));
		//return Collections.singletonList(new RatingInfo("gaurav1", "movie01", 5));
	}
}
