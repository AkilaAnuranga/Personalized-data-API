package org.smashtaps.product.controller;

import jakarta.validation.Valid;
import org.smashtaps.product.dto.ProductRequest;
import org.smashtaps.product.dto.ProductResponse;
import org.smashtaps.product.entity.Product;
import org.smashtaps.product.exception.ResourceNotFoundException;
import org.smashtaps.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/internal/products")
public class InternalProductController {

    private final ProductService service;

    public InternalProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> productList(@PathVariable String id) throws ResourceNotFoundException {
        ProductResponse productResponse = service.getProduct(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> productMetadata(@Valid @RequestBody ProductRequest request){
        ProductResponse created = service.saveProduct(request);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
