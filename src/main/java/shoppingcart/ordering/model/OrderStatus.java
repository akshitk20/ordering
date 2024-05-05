package shoppingcart.ordering.model;

import jakarta.persistence.Embedded;

public enum OrderStatus {
    DRAFT,PENDING,CREATED,COMPLETED,CANCELLED;
}
