package org.smashtaps.product.specs;

import org.smashtaps.product.entity.ShopperProduct;
import org.springframework.data.jpa.domain.Specification;

public class ShopperProductSpecs {
    public static Specification<ShopperProduct> filterByShopperId(String shopperId){
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("shopper").get("shopperId"), shopperId);
    }

    public static Specification<ShopperProduct> filterByBrand(String brand) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("product").get("brand"), brand);
    }

    public static Specification<ShopperProduct> filterByCategory(String category) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("product").get("category"), category);
    }

}
