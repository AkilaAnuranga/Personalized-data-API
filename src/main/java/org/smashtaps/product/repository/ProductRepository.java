package org.smashtaps.product.repository;

import org.smashtaps.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByProductId(String id);
}
