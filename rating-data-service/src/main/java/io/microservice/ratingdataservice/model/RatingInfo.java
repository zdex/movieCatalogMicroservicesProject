package io.microservice.ratingdataservice.model;

public class RatingInfo {

	private String moviedId;
	private int rating;

	public RatingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingInfo(String moviedId, int rating) {
		super();

		this.moviedId = moviedId;
		this.rating = rating;
	}

	public String getMoviedId() {
		return moviedId;
	}

	public void setMoviedId(String moviedId) {
		this.moviedId = moviedId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moviedId == null) ? 0 : moviedId.hashCode());
		result = prime * result + rating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatingInfo other = (RatingInfo) obj;
		if (moviedId == null) {
			if (other.moviedId != null)
				return false;
		} else if (!moviedId.equals(other.moviedId))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RatingInfo [moviedId=" + moviedId + ", rating=" + rating + "]";
	}

}
