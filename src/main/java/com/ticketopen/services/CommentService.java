package com.ticketopen.services;

import com.ticketopen.domain.Comment;
import com.ticketopen.domain.Person;
import com.ticketopen.domain.Ticket;
import com.ticketopen.dto.CommentNewDTO;
import com.ticketopen.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repo;


    public Comment fromDTO(CommentNewDTO objDto) {
        Person person = new Person(objDto.getPersonId(), null, null, null, null);
        Ticket ticket = new Ticket(objDto.getTicketId(), null, null, null, null, null);
        Comment comment = new Comment(null, objDto.getText(), person, ticket);
        ticket.getCommentList().add(comment);

        return comment;
    }


    @Transactional
    public Comment insertComment(Comment obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
