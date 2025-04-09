package br.com.alstwo.sgd.config;

import br.com.alstwo.sgd.domain.User;
import br.com.alstwo.sgd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner createRecords(UserRepository userRepository) {
        return args -> {

            User newUser2 = new User(null, "fabiana", "321", "biana@gmail.com", "Fabiana", "Biana", null, null);
            User newUser1 = new User(null, "christian", "123", "ct@ctfera.comn", "Christian", "CT", null, null);
            userRepository.saveAll(List.of(newUser1, newUser2));

        };
    }

}
