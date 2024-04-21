package com.example.springboot.services;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @BeforeAll
    public static void setUp() {
        MockitoAnnotations.openMocks(ProductServiceTest.class);
    }

    @Test
    @DisplayName("Should get product with success")
    void createProductSuccess() {
        ProductModel expected = makeFakeProduct();
        ProductRecordDto fakeProduct = new ProductRecordDto(expected.getName(), expected.getValue());

        Mockito.when(productRepository.save(Mockito.any(ProductModel.class))).thenReturn(expected);

        ProductModel result = productService.createProduct(fakeProduct);

        assertThat(result).isEqualTo(expected);
    }

    private ProductModel makeFakeProduct() {
        ProductModel product = new ProductModel();
        product.setId(UUID.randomUUID());
        product.setName("Fake Product");
        product.setValue(BigDecimal.valueOf(800));
        return product;
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void listProducts() {
    }
}