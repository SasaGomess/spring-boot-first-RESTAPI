package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.Category;
import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id).get();
    }
}
