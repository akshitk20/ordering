package shoppingcart.ordering.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    private String customerId;
    private String orderName;
    private Address shippingAddress;
    private Address billingAddress;
    private Payment payment;
    private OrderStatus status = OrderStatus.PENDING;
    private BigDecimal totalPrice;
}
