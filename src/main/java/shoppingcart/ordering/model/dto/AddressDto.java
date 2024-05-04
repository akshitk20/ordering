package shoppingcart.ordering.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String addressLine;
    private String country;
    private String state;
    private String zipCode;
}
