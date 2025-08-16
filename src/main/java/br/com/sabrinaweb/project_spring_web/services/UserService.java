package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.repositories.UserRepository;
import br.com.sabrinaweb.project_spring_web.services.exceptions.DataBaseException;
import br.com.sabrinaweb.project_spring_web.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
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
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert (User user){
        return repository.save(user);
    }
    public void delete (Long id){
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            else {
                repository.deleteById(id);
            }
        }catch (DataIntegrityViolationException e ){
            throw new DataBaseException(e.getMessage());
        }
    }
    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
