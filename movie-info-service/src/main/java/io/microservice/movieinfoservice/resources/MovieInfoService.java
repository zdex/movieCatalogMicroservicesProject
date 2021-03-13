package io.microservice.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.microservice.movieinfoservice.models.MovieInfo;
import io.microservice.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieInfoService {

	@Value("${api-key}")
	private String API_KEY;
		
	@Autowired
	private RestTemplate template;
	
	@RequestMapping("{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary =  template.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + this.API_KEY, MovieSummary.class);
		return new MovieInfo(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
