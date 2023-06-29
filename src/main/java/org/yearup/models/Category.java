package org.yearup.models;

import java.util.ArrayList;
import java.util.List;

public class Category
{
    private int categoryId;
    private String name;
    private String description;
    private List<Category> allCategories;

    public Category(int categoryId, String name, String description)
    {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public Category() {

    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void update(int categoryId, Category category) {
    }

    public void update(Category originalCategory) {
    }

    public void createCategory(Category newCategory) {
    }

    public List<Category> getAllCategories() {
        return allCategories;
    }
    private List<Category> getExpectedCategories() {
        List<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(new Category(1, "Category 1", "Category 1"));
        expectedCategories.add(new Category(1, "Category 1", "Category 1"));
        expectedCategories.add(new Category(1, "Category 1", "Category 1"));
        return expectedCategories;
    }
}
