package io.microservice.moviecatalogservice.models;

import java.util.List;

public class UserRatings {

	private List<RatingInfo> ratings;

	private String userId;
	
	public List<RatingInfo> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingInfo> ratings) {
		this.ratings = ratings;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
