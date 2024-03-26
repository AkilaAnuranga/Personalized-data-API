package org.smashtaps.product.repository;

import org.smashtaps.product.entity.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperProductListRepository extends JpaRepository<ShopperProduct, Long> , JpaSpecificationExecutor<ShopperProduct> {


}
