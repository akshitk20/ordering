package shoppingcart.ordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    private UUID orderId;
    private String customerId;
    private String orderName;
    private List<OrderItems> orderItems;
    private Address shippingAddress;
    private Address billingAddress;
    private Payment payment;
    private OrderStatus status = OrderStatus.PENDING;
    private BigDecimal totalPrice;
}
