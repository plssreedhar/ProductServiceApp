package com.ecommerce.productserviceapp.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException {
    private Long productId;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
