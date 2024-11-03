package com.mahmud.spring_webflux_practice.controllers;

import com.mahmud.spring_webflux_practice.model.Book;
import com.mahmud.spring_webflux_practice.services.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping(value = {"books","/books"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(bookService.getAllBooks());
    }

    @PostMapping()
    public Mono<Book> createBook(@RequestBody Book book) {
        System.out.println(book);
        return Mono.just(bookService.addBook(book));
    }
}