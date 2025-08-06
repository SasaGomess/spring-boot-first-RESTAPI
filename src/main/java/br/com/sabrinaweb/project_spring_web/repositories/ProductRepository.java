package br.com.sabrinaweb.project_spring_web.repositories;

import br.com.sabrinaweb.project_spring_web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
