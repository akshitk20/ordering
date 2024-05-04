package shoppingcart.ordering.service;

import shoppingcart.ordering.model.dto.OrderDto;
import shoppingcart.ordering.model.request.CreateOrderRequest;
import shoppingcart.ordering.model.response.CreateOrderResponse;

public class OrderService {
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        OrderDto orderDto = createOrderRequest.getOrderDto();

        return CreateOrderResponse.builder().build();
    }
}
