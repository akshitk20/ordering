package shoppingcart.ordering.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shoppingcart.ordering.model.Address;
import shoppingcart.ordering.model.Order;
import shoppingcart.ordering.model.OrderItems;
import shoppingcart.ordering.model.Payment;
import shoppingcart.ordering.model.dto.AddressDto;
import shoppingcart.ordering.model.dto.OrderDto;
import shoppingcart.ordering.model.dto.PaymentDto;
import shoppingcart.ordering.model.request.CreateOrderRequest;
import shoppingcart.ordering.model.response.CreateOrderResponse;
import shoppingcart.ordering.repository.OrderRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        log.info("starting to create order for id : {}" , createOrderRequest.getOrderDto().getId());
        OrderDto orderDto = createOrderRequest.getOrderDto();
        Order order = mapToOrder(orderDto);
        Order persistedOrder = orderRepository.save(order);
        log.info("saved to database completed for id : {}" , persistedOrder.getOrderId());
        return CreateOrderResponse.builder()
                .id(persistedOrder.getOrderId().toString())
                .build();
    }

    private Order mapToOrder(OrderDto orderDto) {
        Address shippingAddress = mapToAddress(orderDto.getShippingAddress());
        Address billingAddress = mapToAddress(orderDto.getBillingAddress());
        Payment payment = mapToPayment(orderDto.getPayment());
        Order newOrder = Order.builder()
                .orderId(UUID.fromString(orderDto.getId()))
                .customerId(orderDto.getCustomerId())
                .orderName(orderDto.getOrderName())
                .shippingAddress(shippingAddress)
                .billingAddress(billingAddress)
                .payment(payment)
                .build();
        orderDto.getOrderItems().forEach(orderItemDto -> newOrder.getOrderItems()
                .add(new OrderItems(orderItemDto.getProductId(),
                        orderItemDto.getQuantity(),
                        orderItemDto.getPrice())));
        return newOrder;
    }

    private Payment mapToPayment(PaymentDto paymentDto) {
        return Payment.builder()
                .cardName(paymentDto.getCardName())
                .cardNumber(paymentDto.getCardNumber())
                .expiration(paymentDto.getExpiration())
                .cvv(paymentDto.getCvv())
                .build();
    }

    private Address mapToAddress(AddressDto addressDto) {
        return Address.builder()
                .firstName(addressDto.getFirstName())
                .lastName(addressDto.getLastName())
                .emailAddress(addressDto.getEmailAddress())
                .addressLine(addressDto.getAddressLine())
                .country(addressDto.getCountry())
                .state(addressDto.getState())
                .zipCode(addressDto.getZipCode())
                .build();
    }

}
