package br.com.sabrinaweb.project_spring_web.config;

import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Silva", "maria@gmail.com", "9999999", "12354a");
        User u2 = new User(null, "Sabrina Goms", "sabrinams@gmail.com", "99997777", "321432b");

        userRepository.saveAll(List.of(u1, u2));
    }
}
