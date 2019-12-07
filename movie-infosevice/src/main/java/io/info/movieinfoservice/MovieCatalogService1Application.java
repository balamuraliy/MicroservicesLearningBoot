package io.info.movieinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class MovieCatalogService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogService1Application.class, args);
	}

}
