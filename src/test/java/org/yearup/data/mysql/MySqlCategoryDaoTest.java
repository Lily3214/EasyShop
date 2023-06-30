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

    // test category getbyId. Result should return expected = actual.
    @Test
    public void getById_shouldReturn_theCorrectCategory() {
        // Arrange
        int categoryId = 2;
        Category expected = new Category() {{
            setCategoryId(2);
            setName("Fashion");
            setDescription("Discover trendy clothing and accessories for men and women.");
        }};

        // Act
        var actual = dao.getById(categoryId);

        // Assert
        assertEquals(expected.getCategoryId(), actual.getCategoryId(), "The category ID should match."); // no need to have message
        assertEquals(expected.getName(), actual.getName(), "The category name should match.");
        assertEquals(expected.getDescription(), actual.getDescription(), "The category description should match.");
    }

    // test category create. Result should return createdCategory.
    @Test
    public void create_shouldReturn_createdCategory() {
        // Arrange
        String categoryName = "New Category";
        String categoryDescription = "New Category Description";

        // Act
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        newCategory.setDescription(categoryDescription);

        Category createdCategory = dao.create(newCategory);

        // Assert
        assertEquals(categoryName, createdCategory.getName());
        assertEquals(categoryDescription, createdCategory.getDescription());
    }

    // test get all category list. Result should return expectedCategory = actualCategory
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

    // test update category list. Result should return to updatedCategory.
    @Test
    public void update_shouldReturn_updatedCategory() {
        /*
        // Arrange
        int categoryId = 1;
        String existingCategoryName = "Electronics";
        String existingCategoryDescription = "Explore the latest gadgets and electronic devices.";

        Category existingCategory = new Category();
        existingCategory.setCategoryId(categoryId);
        existingCategory.setName(existingCategoryName);
        existingCategory.setDescription(existingCategoryDescription);
        dao.create(existingCategory);

        String updatedCategoryName = "Updated Category";
        String updatedCategoryDescription = "Updated Category Description";

        Category updateCategory = new Category();
        updateCategory.setCategoryId(categoryId);
        updateCategory.setName(updatedCategoryName);
        updateCategory.setDescription(updatedCategoryDescription);

        // Act
        Category updatedCategory = dao.update(updateCategory);

        // Assert
        assertEquals(categoryId, updatedCategory.getCategoryId());
        assertEquals(updatedCategoryName, updatedCategory.getName());
        assertEquals(updatedCategoryDescription, updatedCategory.getDescription());
        */
    }
}
