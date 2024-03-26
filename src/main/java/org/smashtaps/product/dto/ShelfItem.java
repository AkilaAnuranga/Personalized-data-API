package org.smashtaps.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShelfItem {


    private String productId;
    private Double relevancyScore;

}
