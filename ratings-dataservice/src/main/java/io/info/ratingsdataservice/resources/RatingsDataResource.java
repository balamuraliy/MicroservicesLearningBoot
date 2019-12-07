package io.info.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.info.ratingsdataservice.models.Rating;
import io.info.ratingsdataservice.models.UserRating;
@RestController
@RequestMapping("/ratingdata")
public class RatingsDataResource {
	
	
	@RequestMapping("/{movieId}")
	public Rating getRatingInfo(@PathVariable("movieId") String movieId) {
	
	return new Rating(movieId,5);

}
	@RequestMapping("user/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
	
		List<Rating> ratings= Arrays.asList(
					new Rating("123556",4),new Rating("33321",5));
		UserRating userratings = new UserRating();
		userratings.setUserRating(ratings);
				
	return  userratings;

}

}