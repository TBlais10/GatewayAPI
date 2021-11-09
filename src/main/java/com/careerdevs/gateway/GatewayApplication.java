package com.careerdevs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GatewayApplication {

	private static final String MY_API_KEY = "hF4GZKXvAM5yV5lroYtw7icPcfp297Q8UJn8xgAd";

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping ("/")
	public String rootRoute () {
		return "Welcome Home";
	}

	@GetMapping("/apod")
	public APOD apodInfo (RestTemplate restTemplate) {
		String URL = "https://api.nasa.gov/planetary/apod?api_key=" + MY_API_KEY;

		APOD apod = restTemplate.getForObject(URL, APOD.class);

		return apod;

	}


}
