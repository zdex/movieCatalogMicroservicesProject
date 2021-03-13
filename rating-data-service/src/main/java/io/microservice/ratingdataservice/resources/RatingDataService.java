package io.microservice.ratingdataservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservice.ratingdataservice.model.RatingInfo;
import io.microservice.ratingdataservice.model.UserRatings;

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
		//return Collections.singletonList(new RatingInfo("movie01", 5));
	}
	
	@RequestMapping("userRatings/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId) {
		UserRatings ratings = new UserRatings();
		List<RatingInfo> list = new ArrayList<RatingInfo>();
		list= Arrays.asList(new RatingInfo("100", 5),
				new RatingInfo("200", 7));
		ratings.setRatings(list);
		return ratings;
		//return Collections.singletonList(new RatingInfo("movie01", 5));
	}
}
