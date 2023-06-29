package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.yearup.models.Category;
import org.yearup.models.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class MySqlCategoryDaoTest extends BaseDaoTestClass {
    private MySqlCategoryDao dao;

    @BeforeEach
    public void setup() {
        dao = new MySqlCategoryDao(dataSource);
    }

    @Test
    public void getById_shouldReturn_theCorrectCategory() {
        // arrange
        int categoryId = 2;
        Category expected = new Category() {{
            setCategoryId(2);
            setName("Fashion");
            setDescription("Discover trendy clothing and accessories for men and women.");
        }};

        // act
        var actual = dao.getById(categoryId);

        // assert
        assertEquals(expected.getCategoryId(), actual.getCategoryId(), "The category ID should match.");
        assertEquals(expected.getName(), actual.getName(), "The category name should match.");
        assertEquals(expected.getDescription(), actual.getDescription(), "The category description should match.");
    }

    @Test
    public void Create() {
        // Arrange
        String categoryName = "New Category";
        String categoryDescription = "New Category Description";

        Category dao = new Category();

        // Act
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        newCategory.setDescription(categoryDescription);
        dao.createCategory(newCategory);

        // Assert
        assertNotNull(newCategory.getCategoryId());
        assertEquals(categoryName, newCategory.getName());
        assertEquals(categoryDescription, newCategory.getDescription());
    }
    @Test
    public void getAllCategories() {
        // Arrange
        // Act
        // Assert
    }
    @Test
    public void Update() {
        // Arrange
        int categoryId = 2;
        String newName = "New Product";
        String newDescription = "New Product Description";

        Category dao = new Category();

        Category originalCategory = dao;

        // Act
        originalCategory.setName(newName);
        originalCategory.setDescription(newDescription);
        dao.update(originalCategory);

        Category updatedCategory = dao;

        // Assert
        assertEquals(categoryId, updatedCategory.getCategoryId());
        assertEquals(newName, updatedCategory.getName());
        assertEquals(newDescription, updatedCategory.getDescription());
    }
}
