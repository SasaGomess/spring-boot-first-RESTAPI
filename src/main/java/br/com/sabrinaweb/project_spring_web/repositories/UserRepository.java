package br.com.sabrinaweb.project_spring_web.repositories;

import br.com.sabrinaweb.project_spring_web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
