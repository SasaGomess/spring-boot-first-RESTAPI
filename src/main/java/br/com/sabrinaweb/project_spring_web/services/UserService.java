package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }
    public User insert (User user){
        return repository.save(user);
    }
}
