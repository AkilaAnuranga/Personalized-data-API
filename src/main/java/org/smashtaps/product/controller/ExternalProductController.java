package org.smashtaps.product.controller;

import jakarta.validation.constraints.Max;
import org.smashtaps.product.entity.ShopperProduct;
import org.smashtaps.product.service.ShopperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/external/products")
public class ExternalProductController {

    private final ShopperService service;

    public ExternalProductController(ShopperService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShopperProduct> getProductByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false, defaultValue = "10") @Max(value = 100, message = "Limit must not exceed 100") int limit
    ){


        return service.getProductListByShopper(shopperId, category, brand, limit);

    }
}
