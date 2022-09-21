package edu.miu.swa.productservice.repository;

import edu.miu.swa.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductId(Integer ProductId);
}
