package org.smashtaps.product.service;

import org.modelmapper.ModelMapper;
import org.smashtaps.product.dto.ProductListRequest;
import org.smashtaps.product.dto.ShelfItem;
import org.smashtaps.product.entity.Product;
import org.smashtaps.product.entity.ShopperProduct;
import org.smashtaps.product.entity.Shopper;
import org.smashtaps.product.repository.ShopperProductListRepository;
import org.smashtaps.product.repository.ProductRepository;
import org.smashtaps.product.repository.ShopperRepository;
import org.smashtaps.product.specs.ShopperProductSpecs;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopperService {



    private final ProductRepository productRepository;

    private final ShopperRepository shopperRepository;

    private final ShopperProductListRepository shopperProductListRepository;

    private final ModelMapper mapper;


    public ShopperService(ProductRepository productRepository, ShopperRepository shopperRepository, ShopperProductListRepository shopperProductListRepository, ModelMapper mapper) {

        this.productRepository = productRepository;
        this.shopperRepository = shopperRepository;
        this.shopperProductListRepository = shopperProductListRepository;
        this.mapper = mapper;
    }

    public List<ShopperProduct> getProductListByShopper(String shopperId, String category, String brand, int limit ){

        Specification<ShopperProduct> spec = Specification.where(ShopperProductSpecs.filterByShopperId(shopperId));

        if (brand != null && !brand.isEmpty()) {
            spec = spec.and(ShopperProductSpecs.filterByBrand(brand));
        }

        if (category != null && !category.isEmpty()) {
            spec = spec.and(ShopperProductSpecs.filterByCategory(category));
        }

        return shopperProductListRepository.findAll(spec, PageRequest.of(0,limit)).getContent();

    }

    public void saveShopperProductList(ProductListRequest request){

        Optional<Shopper> find = shopperRepository.findByShopperId(request.getShopperId());

        Shopper shopper = find.orElseGet(() -> Shopper.builder().shopperId(request.getShopperId()).build());

        List<ShopperProduct> products = new ArrayList<ShopperProduct>();

        for (ShelfItem item :request.getShelf()){

            Optional<Product> findProduct = productRepository.findByProductId(item.getProductId());

            if(findProduct.isPresent()){
                ShopperProduct product = ShopperProduct.builder()
                        .shopper(shopper)
                        .product(findProduct.get())
                        .relevancyScore(item.getRelevancyScore())
                        .build();
                products.add(product);
            }

        }

        shopper.setProducts(products);

        shopperRepository.save(shopper);


    }
}
