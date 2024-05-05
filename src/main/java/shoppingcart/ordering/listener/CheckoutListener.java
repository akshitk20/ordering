package shoppingcart.ordering.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import shoppingcart.ordering.model.OrderStatus;
import shoppingcart.ordering.model.dto.AddressDto;
import shoppingcart.ordering.model.dto.BasketCheckoutDTO;
import shoppingcart.ordering.model.dto.OrderDto;
import shoppingcart.ordering.model.dto.PaymentDto;
import shoppingcart.ordering.model.request.CreateOrderRequest;
import shoppingcart.ordering.service.OrderService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutListener {

    private final OrderService orderService;

    @KafkaListener(topics = "checkout-topic", groupId = "group_id")
    public void consume(BasketCheckoutDTO basketCheckoutDTO) {
        log.info("inside checkout listener ");
        CreateOrderRequest createOrderRequest = mapToRequest(basketCheckoutDTO);
        orderService.createOrder(createOrderRequest);
    }

    private CreateOrderRequest mapToRequest(BasketCheckoutDTO basketCheckoutDTO) {
        AddressDto shippingAddress = mapToAddressDto(basketCheckoutDTO);
        AddressDto billingAddress = mapToAddressDto(basketCheckoutDTO);
        PaymentDto paymentDto = mapToPaymentDto(basketCheckoutDTO);
        OrderDto orderDto = OrderDto.builder()
                .id(UUID.randomUUID().toString())
                .customerId(basketCheckoutDTO.getCustomerId())
                .orderName(basketCheckoutDTO.getUserName())
                .status(OrderStatus.CREATED)
                .shippingAddress(shippingAddress)
                .billingAddress(billingAddress)
                .payment(paymentDto)
                .build();
        return CreateOrderRequest.builder()
                .orderDto(orderDto)
                .build();
    }

    private PaymentDto mapToPaymentDto(BasketCheckoutDTO basketCheckoutDTO) {
        return PaymentDto.builder().build();
    }

    private AddressDto mapToAddressDto(BasketCheckoutDTO basketCheckoutDTO) {
        return AddressDto.builder().build();
    }
}
