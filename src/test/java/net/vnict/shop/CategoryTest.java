package net.vnict.shop;
import static org.assertj.core.api.Assertions.assertThat;
import net.vnict.shop.domain.entities.Category;
import net.vnict.shop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {

    @Autowired
    CategoryService categoryService;

    @Test
    public void testGetCategory() {
        Category category = categoryService.findOne(1);
        assertThat("Pizza").isEqualTo(category.getName());
    }

    @Test
    public void testSaveCategory() {
        Category category = new Category();
        category.setName("Drink");
        categoryService.save(category);
        List<Category> categories = (List<Category>) categoryService.findAll();
       Category category1 = categoryService.findOne(categories.size()-1);
       assertThat(category.getName()).isEqualTo(category1.getName());
    }

}