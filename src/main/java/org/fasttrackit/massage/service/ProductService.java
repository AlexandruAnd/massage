package org.fasttrackit.massage.service;

import org.fasttrackit.massage.domain.Product;
import org.fasttrackit.massage.persistance.ProductRepository;
import org.fasttrackit.massage.transfer.SaveProductRequest;
import org.fasttrackit.massage.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(SaveProductRequest request){

        LOGGER.info("Appoiment {}",request);
        Product product= new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setId(request.getId());
        product.setData(request.getData());


        return productRepository.save(product);

    }

    public Product getProduct(long id){
        LOGGER.info("Retrieving appoiment {}", id);

        return productRepository.findById(id).
                        orElseThrow(() -> new ResourceNotFoundException
                        ("Customer" + id + " not found."));
    }
}