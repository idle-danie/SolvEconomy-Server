package sogong.solveconomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SolveconomyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolveconomyApplication.class, args);
	}

}
