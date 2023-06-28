package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.yearup.models.Category;

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
            setName("Cat");
            setDescription("Discover trendy clothing and accessories for men and women.");
        }};

        // act
        var actual = dao.getById(categoryId);

        // assert
        assertEquals(expected.getCategoryId(), actual.getCategoryId(), "The category ID should match.");
        assertEquals(expected.getName(), actual.getName(), "The category name should match.");
        assertEquals(expected.getDescription(), actual.getDescription(), "The category description should match.");
    }

    /*@Test
    List<Category> getAllCategories() {

        // Arrange
        List<Category> categories = createMockCategories();
        when(mySqlCategoryDao.getAllCategories()).thenReturn(categories);

        // Act
        List<Category> actualCategories = mySqlCategoryDao.getAllCategories();

        // Assert
        assertNotNull(actualCategories);
        assertEquals(3, actualCategories.size());
        return categories;
    }

    private List<Category> createMockCategories() {
        // Create and return mock categories
        return List.of(
                new Category(1, "Category 1", "Description 1"),
                new Category(2, "Category 2", "Description 2"),
                new Category(3, "Category 3", "Description 3")
        );
    }
}*/
        /* // Arrange
        Category category = new Category(1, "Category 1", "Description 1");

        // Act
        List<Category> categories = getAllCategories();

        // Assert
        assertEquals(1, categories.size());
        assertEquals(category.getCategoryId(), categories.get(0).getCategoryId());
        assertEquals(category.getName(), categories.get(0).getName());
        assertEquals(category.getDescription(), categories.get(0).getDescription());
        return categories;
    }*/
    @Test
    void getById() {
        // Arrange
        Category category = new Category(1, "Category 1", "Description 1");

        // Act
        int categoryId = category.getCategoryId();

        // Assert
        assertEquals(1, categoryId);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
        /*// create an instance of the class that contains the update method
        Category category = new Category();

        // create an object to be updated
        Category category2 = new Category();
        category2.setCategoryId(1);
        category2.setName("John");

        // call the update method with the object to be updated
        category.update(category2);

        // verify that the object was updated correctly
        assertEquals("John", category.getName());
    }
    @Test
    void delete() {
    }

    // right click on the Java file, and generate and ok
    // do some test inside of this file.
*/
    }
}
