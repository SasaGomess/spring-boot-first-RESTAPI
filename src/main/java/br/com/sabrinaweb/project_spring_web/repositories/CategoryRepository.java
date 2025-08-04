package br.com.sabrinaweb.project_spring_web.repositories;

import br.com.sabrinaweb.project_spring_web.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
