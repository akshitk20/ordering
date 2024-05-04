package shoppingcart.ordering.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
}
