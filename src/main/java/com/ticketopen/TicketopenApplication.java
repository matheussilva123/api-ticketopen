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

        Department dep1 = new Department(null, "Tecnologia");
        Department dep2 = new Department(null, "Administração");

        Category cat1 = new Category(null, "Impressora", dep1);
        Category cat2 = new Category(null, "Rede", dep1);
        Category cat3 = new Category(null, "Manutenção na máquina", dep1);
        Category cat4 = new Category(null, "Limpeza na máquina", dep1);
        Category cat5 = new Category(null, "Criar usuário no Ticket Open", dep1);
        Category cat6 = new Category(null, "Restaurar dados perdidos", dep1);
        Category cat7 = new Category(null, "Limpar disco rígido", dep1);

        Category cat8 = new Category(null, "Cotação de novos serviços", dep2);
        Category cat9 = new Category(null, "Manutenção nas estruturas", dep2);
        Category cat10 = new Category(null, "Emissão de novo contrato", dep2);
        Category cat11 = new Category(null, "Reembolso de Despesas", dep2);
        Category cat12 = new Category(null, "Compras para o prédio", dep2);
        Category cat13 = new Category(null, "Solicitação de uber", dep2);
        Category cat14 = new Category(null, "Contatar motoboy para serviços externos", dep2);


        dep1.getCategoryList().addAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        dep2.getCategoryList().addAll(Arrays.asList(cat8, cat9, cat10, cat11, cat12, cat13, cat14));

        Person person1 = new Person(null, "Matheus da Silva Santos",
                "matheus_silva521@hotmail.com", dep2);
        Person person2 = new Person(null, "Rafael Araujo da Silva",
                "rafaelajds@gmail.com", dep1);

        dep1.getPersonList().addAll(Arrays.asList(person1, person2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Ticket ticket1 = new Ticket(null, "A impressora não está imprimindo precisamos trocar o tonner",
                sdf.parse("18/06/2020 16:00"),
                sdf.parse(""), StateTicket.OPEN, cat1);

        ticket1.getPersonList().addAll(Arrays.asList(person1, person2));

        Ticket ticket2 = new Ticket(null, "Impressora está com defeito",
                sdf.parse("02/01/2020 16:00"),
                sdf.parse(""), StateTicket.OPEN, cat1);

        ticket2.getPersonList().addAll(Arrays.asList(person1, person2));

        Comment comment1 = new Comment(null, "A impressora voltou a funcionar", person1, ticket1);
        ticket1.getCommentList().addAll(Arrays.asList(comment1));


        departmentRepository.saveAll(Arrays.asList(dep1, dep2));
        personRepository.saveAll(Arrays.asList(person1, person2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7,
                cat8, cat9, cat10, cat11, cat12, cat13, cat14));
        ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));
        commentRepository.saveAll(Arrays.asList(comment1));
    }
}
