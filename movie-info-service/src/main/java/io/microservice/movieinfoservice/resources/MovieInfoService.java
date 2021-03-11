package io.microservice.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservice.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/movies")
public class MovieInfoService {

	@RequestMapping("{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
		return new MovieInfo("movie01", "transformer", "transformer description");
	}
}
