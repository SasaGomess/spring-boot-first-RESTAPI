package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.Product;
import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.repositories.ProductRepository;
import br.com.sabrinaweb.project_spring_web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).get();
    }
}
