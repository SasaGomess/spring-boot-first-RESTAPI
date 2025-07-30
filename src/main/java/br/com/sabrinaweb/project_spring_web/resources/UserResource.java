package br.com.sabrinaweb.project_spring_web.resources;

import br.com.sabrinaweb.project_spring_web.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria Silva", "maria@gmail.com", "9999999", "12354a");
        return ResponseEntity.ok().body(u);
    }
}
