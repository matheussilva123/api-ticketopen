package com.ticketopen;

import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.repositories.CategoryRepository;
import com.ticketopen.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TicketopenApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketopenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Department dep1 = new Department(null, "Technology");

        Category cat1 = new Category(null, "Printer", dep1);
        Category cat2 = new Category(null, "Network", dep1);

        departmentRepository.saveAll(Arrays.asList(dep1));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
    }
}
