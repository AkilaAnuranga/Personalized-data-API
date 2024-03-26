package org.smashtaps.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {



    @NotBlank(message = "productID can not be blank")
    @NotNull(message = "productID can not be blank")
    private String productId;

    @NotBlank(message = "category can not be blank")
    @NotNull(message = "category can not be blank")
    private String category;

    @NotBlank(message = "brand can not be blank")
    @NotNull(message = "brand can not be blank")
    private String brand;
}
