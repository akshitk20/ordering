package shoppingcart.ordering.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketCheckoutDTO {
    private String userName;
    private String customerId;
    private BigDecimal totalPrice;

    // shipping and billing address
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String addressLine;
    private String country;
    private String state;
    private String zipCode;

    // payment
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
}
