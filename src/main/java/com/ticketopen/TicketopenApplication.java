package com.ticketopen;

import com.ticketopen.domain.Category;
import com.ticketopen.domain.Department;
import com.ticketopen.domain.Person;
import com.ticketopen.domain.Ticket;
import com.ticketopen.domain.enums.StateTicket;
import com.ticketopen.repositories.CategoryRepository;
import com.ticketopen.repositories.DepartmentRepository;
import com.ticketopen.repositories.PersonRepository;
import com.ticketopen.repositories.TicketRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(TicketopenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Department dep1 = new Department(null, "Technology");
        Department dep2 = new Department(null, "Financial");

        Category cat1 = new Category(null, "Printer", dep1);
        Category cat2 = new Category(null, "Network", dep1);
        Category cat3 = new Category(null, "Expenses refund", dep2);
        Category cat4 = new Category(null, "Invoice issuance", dep2);

        dep1.getCategoryList().addAll(Arrays.asList(cat1, cat2));
        dep2.getCategoryList().addAll(Arrays.asList(cat3, cat4));

        Person person1 = new Person(null, "Matheus da Silva Santos", dep2);
        Person person2 = new Person(null, "Rafael Araujo da Silva", dep1);

        dep1.getPersonList().addAll(Arrays.asList(person1, person2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Ticket ticket1 = new Ticket(null, "Preciso de uma categoria",
                sdf.parse("18/06/2020 16:00"),
                sdf.parse("18/06/2020 19:52"), StateTicket.OPEN, dep1, cat1);

        ticket1.getPersonList().addAll(Arrays.asList(person1, person2));


        departmentRepository.saveAll(Arrays.asList(dep1, dep2));
        personRepository.saveAll(Arrays.asList(person1, person2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        ticketRepository.saveAll(Arrays.asList(ticket1));
    }
}
