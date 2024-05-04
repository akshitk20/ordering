package shoppingcart.ordering.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoppingcart.ordering.model.OrderStatus;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id;
    private String customerId;
    private String orderName;
    private AddressDto shippingAddress;
    private AddressDto billingAddress;
    private PaymentDto payment;
    private OrderStatus status;
    private List<OrderItemDto> orderItems;
}
