package pk.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = { "pk.word",
		"pk.security.authorizationframework" })
@EnableJpaRepositories(basePackages = { "pk.security.authorizationframework.repository", "pk.word.repository" })
@EntityScan(basePackages = { "pk.security.authorizationframework.entity", "pk.word.entity" })
public class WordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
