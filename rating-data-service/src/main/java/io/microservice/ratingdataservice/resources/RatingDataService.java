package io.microservice.ratingdataservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservice.ratingdataservice.model.RatingInfo;

@RestController
@RequestMapping("/ratings")
public class RatingDataService {

	@RequestMapping("{movieId}")
	public List<RatingInfo> getUserRatingInfo(@PathVariable("movieId") String movieId) {
		
		return Collections.singletonList(new RatingInfo("gaurav1", "movie01", 5));
	}
}
