package br.com.sabrinaweb.project_spring_web.config;

import br.com.sabrinaweb.project_spring_web.entities.Order;
import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.entities.enums.OrderStatus;
import br.com.sabrinaweb.project_spring_web.repositories.OrderRepository;
import br.com.sabrinaweb.project_spring_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Silva", "maria@gmail.com", "9999999", "12354a");
        User u2 = new User(null, "Sabrina Goms", "sabrinams@gmail.com", "99997777", "321432b");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), u1, OrderStatus.PAID);

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
