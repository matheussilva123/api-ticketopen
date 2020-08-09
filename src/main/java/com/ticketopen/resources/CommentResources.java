package com.ticketopen.resources;

import com.ticketopen.domain.Comment;
import com.ticketopen.dto.CommentNewDTO;
import com.ticketopen.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/comments")
public class CommentResources {

    @Autowired
    private CommentService service;

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertComment(@Valid @RequestBody CommentNewDTO objDto) {
        Comment obj = service.fromDTO(objDto);
        obj = service.insertComment(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
