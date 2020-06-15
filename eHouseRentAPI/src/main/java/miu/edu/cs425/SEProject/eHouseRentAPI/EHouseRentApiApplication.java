package miu.edu.cs425.SEProject.eHouseRentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@CrossOrigin
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EHouseRentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EHouseRentApiApplication.class, args);
	}
//
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**");
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*")
						.allowedMethods("GET", "POST", "OPTIONS", "PUT")
						.allowCredentials(true);
			}
		};
	}
}
