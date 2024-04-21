package com.example.springboot.services.interfaces;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface ProductServiceInterface {
    public abstract ProductModel createProduct(ProductRecordDto productRecordDto);
    public abstract ProductModel updateProduct(UUID id, ProductRecordDto productRecordDto);
    public abstract void deleteProduct(UUID id);
    public abstract ProductModel getProduct(UUID id);
    public abstract Page<ProductModel> listProducts(Pageable pagination);
}
