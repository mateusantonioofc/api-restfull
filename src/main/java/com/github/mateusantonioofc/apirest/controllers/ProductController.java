package com.github.mateusantonioofc.apirest.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.mateusantonioofc.apirest.dtos.ProductRecordDto;
import com.github.mateusantonioofc.apirest.models.ProductModel;
import com.github.mateusantonioofc.apirest.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Object> saveProducts(@RequestBody @Valid ProductRecordDto productRecordDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        productRepository.save(productModel);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(getAllProducts());
    }

    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
    	return ResponseEntity.status(HttpStatus.OK)
            .body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductsById(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);

        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found");
        }
        
        return ResponseEntity.status(HttpStatus.OK)
            .body(productModel.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductsById(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);

        if (productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found");
        }
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(getAllProducts());
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductById(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> productFind = productRepository.findById(id);

        if (productFind.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Product not found");
        }

        var productModel = productFind.get();
        
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK)
            .body(productRepository.save(productModel));
    }
    
}