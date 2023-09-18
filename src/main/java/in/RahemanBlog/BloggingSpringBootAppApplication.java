package in.RahemanBlog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloggingSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingSpringBootAppApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		
		return new ModelMapper();
	}
}
