package br.com.alstwo.sgd;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userService.create(new User(null, "alisson", "123", "alisson@alisson", "AlissonCG", "Alisson", null, null));

	}
}
