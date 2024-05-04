package shoppingcart.ordering.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
}
