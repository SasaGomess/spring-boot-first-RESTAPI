package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.Category;
import br.com.sabrinaweb.project_spring_web.entities.Product;
import br.com.sabrinaweb.project_spring_web.repositories.ProductRepository;
import br.com.sabrinaweb.project_spring_web.services.exceptions.DataBaseException;
import br.com.sabrinaweb.project_spring_web.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).get();
    }
    public Product insert(Product product){
        Set<Category> categoriesFound = new HashSet<>();

        for (Category cat : product.getCategories()){
            Category category = categoryService.findById(cat.getId());
            categoriesFound.add(category);
        }

        product.getCategories().clear();

        for (Category category: categoriesFound){
            product.getCategories().add(category);
        }
        return repository.save(product);
    }

    public void delete(Long id){
        try {
            if (!repository.existsById(id)){
                throw new ResourceNotFoundException(id);
            } else {
                repository.deleteById(id);
            }
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
