package com.mahmud.spring_webflux_practice.controllers;

import com.mahmud.spring_webflux_practice.model.Book;
import com.mahmud.spring_webflux_practice.services.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = {"/books","/books/"})
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return Flux.fromIterable(bookService.getAllBooks());
    }

    @PostMapping
    public Mono<Book> addBook(@RequestBody Book book) {
        return Mono.just(bookService.addBook(book));
    }

    @GetMapping("/{id}")
    public Mono<Book> getBookById(@PathVariable("id") Long id) {
        return Mono.justOrEmpty(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public Mono<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Mono<Book> savedBookMono = Mono.justOrEmpty(bookService.getBookById(id));
        Book savedBook = savedBookMono.block();
        if (savedBook != null) {
            book.setId(id);
            bookService.updateBook(book);
            return Mono.just(bookService.updateBook(book));
        }
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return Mono.empty();
    }
}
