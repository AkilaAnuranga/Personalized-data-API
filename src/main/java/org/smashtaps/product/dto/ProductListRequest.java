package org.smashtaps.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.Set;

@Data
public class ProductListRequest {

    @NotNull(message = "shopperId is required")
    @NotBlank(message = "shopperId is required")
    private String shopperId;

    private Set<ShelfItem> shelf;

}
