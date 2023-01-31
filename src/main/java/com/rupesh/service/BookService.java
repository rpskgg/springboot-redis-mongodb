package com.rupesh.service;

import com.rupesh.dao.BookRepository;
import com.rupesh.exception.BookNotFoundException;
import com.rupesh.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public static Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    @Autowired
    private BookRepository bookRepository;

    private final String bookCache = "book";

    @Cacheable(cacheNames = bookCache)
    public List<Book> get(){
        LOGGER.info("entry -> get");
        return bookRepository.findAll();
    }

    @Cacheable(cacheNames = bookCache, key = "#id")
    public Book get(Integer id){
        LOGGER.info("entry -> get :: id = {}", id);
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElseThrow(BookNotFoundException::new);
    }

    @Cacheable(cacheNames = bookCache, key = "#book.id")
    public Book create(Book book){
        LOGGER.info("entry -> create :: book {}", book);
        return bookRepository.save(book);
    }

    @CacheEvict(cacheNames = bookCache, key = "#id")
    public String delete(Integer id){
        LOGGER.info("entry -> delete :: id = {}", id);
        bookRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
