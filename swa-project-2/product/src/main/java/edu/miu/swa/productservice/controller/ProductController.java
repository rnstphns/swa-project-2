package edu.miu.swa.productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.miu.swa.productservice.dto.ApiResponse;
import edu.miu.swa.productservice.dto.OrderItem;
import edu.miu.swa.productservice.dto.OrderRequest;
import edu.miu.swa.productservice.model.Product;
import edu.miu.swa.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/products")
    public List<Product> retrieveProducts(){

        List<Product> product
                = productRepository.findAll();

        if(product.isEmpty()) {
            throw new RuntimeException
                    ("Unable to find product data");
        }

        return product;
    }

    @GetMapping("/product/{productId}")
    public  Optional<Product> retrieveProduct(@PathVariable("productId") Integer productId){

        Product product = productRepository.findByProductId(productId);

        if(product.getNumInStock() < 50){
            //TODO notify warehouse/stocking service
        }
        
        return Optional.of(product);

    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderRequest request) throws JsonProcessingException {
        List<Product> products = new ArrayList<>();
        for (OrderItem item : request.getItems()) {
            Product p=productRepository.findByProductId(item.getId());
            products.add(p);
            if(p.getNumInStock() < item.getNumOfItems()){

                return ResponseEntity.ok(new ApiResponse(false, "Product with Id " + item.getId() + " is out of stock!"));
            }
        }
        for (int i = 0; i < products.size() -1; i++){
            Product product = products.get(i);
            product.setNumInStock(product.getNumInStock() - request.getItems().get(i).getNumOfItems());
            if(product.getNumInStock() <= 50){
                //TODO notify warehouse/stocking service
            }
        }
        productRepository.saveAll(products);
        return ResponseEntity.ok(new ApiResponse(true, ""));
    }

    @PostMapping("/product/save")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
