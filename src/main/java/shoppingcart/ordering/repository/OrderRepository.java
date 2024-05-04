package shoppingcart.ordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoppingcart.ordering.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
