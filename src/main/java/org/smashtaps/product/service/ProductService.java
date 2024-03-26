package org.smashtaps.product.service;

import org.modelmapper.ModelMapper;
import org.smashtaps.product.dto.ProductRequest;
import org.smashtaps.product.dto.ProductResponse;
import org.smashtaps.product.entity.Product;
import org.smashtaps.product.exception.ResourceNotFoundException;
import org.smashtaps.product.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    public ProductService(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductResponse saveProduct(ProductRequest product){

        Product builder = Product.builder()
                .productId(product.getProductId())
                .brand(product.getBrand())
                .category(product.getCategory())
                .build();

        Product created = repository.save(builder);

        return mapper.map(created,ProductResponse.class);
    }

    public ProductResponse getProduct(String id) throws ResourceNotFoundException {

        return repository.findByProductId(id)
                .map(product -> mapper.map(product,ProductResponse.class))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
