package br.com.alstwo.sgd;

import br.com.alstwo.sgd.domain.Domain;
import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.services.DomainService;
import br.com.alstwo.sgd.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@RequiredArgsConstructor
@SpringBootApplication
public class Main implements CommandLineRunner {

	private final UserService userService;
	private final DomainService domainService;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Double randomNumber = Math.random();
	  	userService.create(new User(null, "teste", "123", "alisson@email" + (int)((randomNumber * 10)* 99.99) + ".com", "AlissonCG", "Alisson", 1, null, null ));
		domainService.create(new Domain(null, 1, "Teste", "TXT", 1, "testeMain"));
	}
}
