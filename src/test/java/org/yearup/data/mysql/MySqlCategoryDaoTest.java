package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.yearup.models.Category;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(expected.getCategoryId(), actual.getCategoryId(), "The category ID should match."); // no need to have message
        assertEquals(expected.getName(), actual.getName(), "The category name should match.");
        assertEquals(expected.getDescription(), actual.getDescription(), "The category description should match.");
    }

    @Test
    public void create_shouldReturn_createdCategory() {
        // Arrange
        String categoryName = "New Category";
        String categoryDescription = "New Category Description";

        // Act
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        newCategory.setDescription(categoryDescription);

        Category createdCategory =  dao.create(newCategory);

        // Assert
        assertEquals(categoryName, createdCategory.getName());
        assertEquals(categoryDescription, createdCategory.getDescription());
    }
    @Test
    public void getAllCategories_shouldReturn_theCorrectCategoryList() {
        // Arrange
        List<Category> expectedCategories = List.of(
                new Category(1, "Electronics", "Explore the latest gadgets and electronic devices."),
                new Category(2, "Fashion", "Discover trendy clothing and accessories for men and women."),
                new Category(3, "Home & Kitchen", "Find everything you need to decorate and equip your home.")
        );

        // Act
        Category category = new Category();
        List<Category> actualCategories = dao.getAllCategories();
        // Assert
        for (int i = 0; i < expectedCategories.size(); i++) {
            Category expectedCategory = expectedCategories.get(i);
            Category actualCategory = actualCategories.get(i);

            assertEquals(expectedCategory.getCategoryId(), actualCategory.getCategoryId());
            assertEquals(expectedCategory.getName(), actualCategory.getName());
            assertEquals(expectedCategory.getDescription(), actualCategory.getDescription());

        }
    }

    @Test
    public void update_shouldReturn_updatedCategory() {
        // Arrange
        int categoryId = 1;
        String categoryName = "New Category";
        String categoryDescription = "New Category Description";

        Category updateCategory = new Category();
        updateCategory.setCategoryId(categoryId);
        updateCategory.setName(categoryName);
        updateCategory.setDescription(categoryDescription);

        // Act
        Category updatedCategory = dao.create(updateCategory);

        // Assert
        assertEquals(categoryId, updatedCategory.getCategoryId());
        assertEquals(categoryName, updatedCategory.getName());
        assertEquals(categoryDescription, updatedCategory.getDescription());
    }
    }
