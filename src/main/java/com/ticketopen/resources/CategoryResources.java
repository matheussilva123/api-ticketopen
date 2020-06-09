package com.ticketopen.resources;

import com.ticketopen.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> categoryList() {

        Category cat1 = new Category(1, "technology");
        Category cat2 = new Category(2, "office");

        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);

        return categories;
    }

}
