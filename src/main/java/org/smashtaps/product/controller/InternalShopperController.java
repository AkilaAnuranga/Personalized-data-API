package org.smashtaps.product.controller;

import jakarta.validation.Valid;
import org.smashtaps.product.dto.ProductListRequest;
import org.smashtaps.product.service.ShopperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/internal/shopper")
public class InternalShopperController {


    private final ShopperService service;

    public InternalShopperController(ShopperService service) {
        this.service = service;
    }


    @PostMapping("/products")
    public ResponseEntity<String> addShopperPersonalizedProducts(@Valid @RequestBody ProductListRequest request){

        service.saveShopperProductList(request);

        return ResponseEntity.ok("Shopper saved with Products");

    }





}
