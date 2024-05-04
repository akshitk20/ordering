package shoppingcart.ordering.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private String orderId;
    private String productId;
    private int quantity;
    private BigDecimal price;
}
