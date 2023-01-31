package com.rupesh.controller;


import com.rupesh.model.Book;
import com.rupesh.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book){
        LOGGER.info("save book");
        return bookService.create(book);
    }

    @GetMapping
    public List<Book> get() {
        return bookService.get();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id){
      return bookService.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        return bookService.delete(id);
    }

}

