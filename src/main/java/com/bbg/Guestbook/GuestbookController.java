package com.bbg.Guestbook;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbook")
public class GuestbookController {
    private final GuestbookRepository repository;

    @PostMapping
    public Gusetbook postMethodName(@RequestBody Gusetbook gusetbook) {
        return repository.save(gusetbook);
    }
    
    @GetMapping
    public List<Gusetbook> read() {
        return repository.findAll();
    }
    
}
