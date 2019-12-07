package io.info.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.info.moviecatalogservice.models.CatalogItem;
import io.info.moviecatalogservice.models.Movie;
import io.info.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	public RestTemplate restTemplate;

	@Value("${server.port}")
	public int port;

	@RequestMapping("service/{userId}")
	  public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId) {

		// Before adding the service name directly in url
		/* UserRating ratings =
		 restTemplate.getForObject("http://localhost:3324/ratingdata/user/userId" +
		userId, UserRating.class);*/

		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingdata/user/userId" + userId,
				UserRating.class);

		// Before adding the service name to url
		/*
		 * return ratings.getUserRating().stream() .map(rating -> { Movie movie =
		 * restTemplate.getForObject("http://localhost:3323/movies/movieId" +
		 * rating.getMovieId(), Movie.class); return new CatalogItem(movie.getName(),
		 * "Description", rating.getRating()); }) .collect(Collectors.toList());
		 */

		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/movieId" + rating.getMovieId(),
					Movie.class);
			return new CatalogItem(movie.getName(), "Description", rating.getRating());
		}).collect(Collectors.toList());

	}  
	
	
}
