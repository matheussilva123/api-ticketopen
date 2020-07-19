package com.ticketopen;

import com.ticketopen.domain.*;
import com.ticketopen.domain.enums.StateTicket;
import com.ticketopen.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class TicketopenApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CommentRepository commentRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketopenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Department dep1 = new Department(null, "Technology");
        Department dep2 = new Department(null, "Financial");
        Department dep3 = new Department(null, "Marketing");
        Department dep4 = new Department(null, "Cleaning");
        Department dep5 = new Department(null, "Human Resources");
        Department dep6 = new Department(null, "Administration");
        Department dep7 = new Department(null, "Management");
        Department dep8 = new Department(null, "Maintenance");

        Category cat1 = new Category(null, "Printer", dep1);
        Category cat2 = new Category(null, "Network", dep1);
        Category cat3 = new Category(null, "Expenses refund", dep2);
        Category cat4 = new Category(null, "Invoice issuance", dep2);

        dep1.getCategoryList().addAll(Arrays.asList(cat1, cat2));
        dep2.getCategoryList().addAll(Arrays.asList(cat3, cat4));

        Person person1 = new Person(null, "Matheus da Silva Santos",
                "matheus.dias@ifood.com.br", dep2);
        Person person2 = new Person(null, "Rafael Araujo da Silva",
                "rafaelajds@gmail.com", dep1);

        dep1.getPersonList().addAll(Arrays.asList(person1, person2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Ticket ticket1 = new Ticket(null, "Please check printer",
                sdf.parse("18/06/2020 16:00"),
                sdf.parse("18/06/2020 19:52"), StateTicket.OPEN, cat1);

        ticket1.getPersonList().addAll(Arrays.asList(person1, person2));

        Comment comment1 = new Comment(null, "The printer is normal...", person1, ticket1);
        ticket1.getCommentList().addAll(Arrays.asList(comment1));


        departmentRepository.saveAll(Arrays.asList(dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8));
        personRepository.saveAll(Arrays.asList(person1, person2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        ticketRepository.saveAll(Arrays.asList(ticket1));
        commentRepository.saveAll(Arrays.asList(comment1));
    }
}
