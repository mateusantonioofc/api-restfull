package com.github.mateusantonioofc.apirest.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.mateusantonioofc.apirest.dtos.ProductRecordDto;
import com.github.mateusantonioofc.apirest.models.ProductModel;
import com.github.mateusantonioofc.apirest.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductRepository productRepository;

    @PostMapping()
    public ResponseEntity<ProductModel> saveProducts(@RequestBody @Valid ProductRecordDto productRecordDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(productRepository.save(productModel));
        
    }

    
    
}
