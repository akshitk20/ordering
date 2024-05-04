package shoppingcart.ordering.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateOrderResponse {
    private String id;
}
