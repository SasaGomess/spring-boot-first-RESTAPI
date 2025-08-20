package br.com.sabrinaweb.project_spring_web.services;

import br.com.sabrinaweb.project_spring_web.entities.Order;
import br.com.sabrinaweb.project_spring_web.entities.OrderItem;
import br.com.sabrinaweb.project_spring_web.entities.Product;
import br.com.sabrinaweb.project_spring_web.entities.User;
import br.com.sabrinaweb.project_spring_web.entities.enums.OrderStatus;
import br.com.sabrinaweb.project_spring_web.repositories.OrderItemRepository;
import br.com.sabrinaweb.project_spring_web.repositories.OrderRepository;
import br.com.sabrinaweb.project_spring_web.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    public UserService clientService;

    @Autowired
    public ProductService productService;

    @Autowired
    public OrderItemRepository orderItemRepository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order order) {
        User clientToInsert = clientService.findById(order.getClient().getId());

        order.setClient(clientToInsert);

        for (OrderItem items : order.getItems()){
            Product productToInsert = productService.findById(items.getProduct().getId());

            items.setProduct(productToInsert);
            items.setPrice(productToInsert.getPrice());
        }

        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        order.setMoment(Instant.now());

        return repository.save(order);
    }
}
