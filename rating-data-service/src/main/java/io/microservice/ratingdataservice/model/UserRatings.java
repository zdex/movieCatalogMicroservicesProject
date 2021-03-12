package io.microservice.ratingdataservice.model;

import java.util.List;

public class UserRatings {

	private List<RatingInfo> ratings;

	public List<RatingInfo> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingInfo> ratings) {
		this.ratings = ratings;
	}
	
}
