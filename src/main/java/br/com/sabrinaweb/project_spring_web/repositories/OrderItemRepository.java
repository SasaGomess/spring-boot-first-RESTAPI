package br.com.sabrinaweb.project_spring_web.repositories;

import br.com.sabrinaweb.project_spring_web.entities.OrderItem;
import br.com.sabrinaweb.project_spring_web.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
