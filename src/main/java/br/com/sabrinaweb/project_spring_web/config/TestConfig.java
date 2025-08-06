package br.com.sabrinaweb.project_spring_web.config;

import br.com.sabrinaweb.project_spring_web.entities.Category;
import br.com.sabrinaweb.project_spring_web.entities.Order;
import br.com.sabrinaweb.project_spring_web.entities.Product;
import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.entities.enums.OrderStatus;
import br.com.sabrinaweb.project_spring_web.repositories.CategoryRepository;
import br.com.sabrinaweb.project_spring_web.repositories.OrderRepository;
import br.com.sabrinaweb.project_spring_web.repositories.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(List.of(c1, c2, c3));
        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        p1.getCategories().add(c2);

        p2.getCategories().add(c1);
        p2.getCategories().add(c3);

        p3.getCategories().add(c3);

        p4.getCategories().add(c3);

        p5.getCategories().add(c2);

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Silva", "maria@gmail.com", "9999999", "12354a");
        User u2 = new User(null, "Sabrina Goms", "sabrinams@gmail.com", "99997777", "321432b");

        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), u1, OrderStatus.SHIPPED);
        Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), u1, OrderStatus.PAID);


        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
