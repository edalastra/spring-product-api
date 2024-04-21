package com.example.springboot.services;

import com.example.springboot.dtos.ProductRecordDto;
   import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import com.example.springboot.services.interfaces.ProductServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductModel createProduct(ProductRecordDto productRecordDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    @Override
    public ProductModel updateProduct(UUID id, ProductRecordDto productRecordDto) {
        ProductModel productModel = getProduct(id);
        BeanUtils.copyProperties(productRecordDto, productModel);
        return productRepository.save(productModel);
    }

    @Override
    public void deleteProduct(UUID id) {
        ProductModel productModel = getProduct(id);
        productRepository.delete(productModel);
    }

    @Override
    public ProductModel getProduct(UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return product.get();
    }

    @Override
    public Page<ProductModel> listProducts(Pageable pagination) {
        return productRepository.findAll(pagination);
    }
}