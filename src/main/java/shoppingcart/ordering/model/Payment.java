package shoppingcart.ordering.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Payment {
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
}
