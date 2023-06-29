package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
// couple of unit test in the category
class MySqlProductDaoTest extends BaseDaoTestClass
{
    private MySqlProductDao dao;

    @BeforeEach
    public void setup()
    {
        dao = new MySqlProductDao(dataSource);
    }

    @Test
    public void getById_shouldReturn_theCorrectProduct()
    {
        // arrange
        int productId = 1;
        Product expected = new Product()
        {{
            setProductId(1);
            setName("Smartphone");
            setPrice(new BigDecimal("499.99"));
            setCategoryId(1);
            setDescription("A powerful and feature-rich smartphone for all your communication needs.");
            setColor("Black");
            setStock(50);
            setFeatured(false);
            setImageUrl("smartphone.jpg");
        }};

        // act
        var actual = dao.getById(productId);

        // assert
        assertEquals(expected.getPrice(), actual.getPrice(), "Because I tried to get product 1 from the database.");
    }
 /*   @Test
    public void Update() {
        Product product = new Product();
        product.setName("New Product");
        product.setPrice(new BigDecimal("10.00"));
        product.setCategoryId(1);
        product.setDescription("New Description");
        product.setColor("Red");
        product.setImageUrl("http://example.com/image.jpg");
        product.setStock(10);
        product.setFeatured(true);

        Product dao = new Product();
        dao.update(1, product);

        Product updatedProduct = dao;
        assertEquals(product.getName(), updatedProduct.getName());
        assertEquals(product.getPrice(), updatedProduct.getPrice());
        assertEquals(product.getCategoryId(), updatedProduct.getCategoryId());
        assertEquals(product.getDescription(), updatedProduct.getDescription());
        assertEquals(product.getColor(), updatedProduct.getColor());
        assertEquals(product.getImageUrl(), updatedProduct.getImageUrl());
        assertEquals(product.getStock(), updatedProduct.getStock());
        assertEquals(product.isFeatured(), updatedProduct.isFeatured());
    }*/
}
