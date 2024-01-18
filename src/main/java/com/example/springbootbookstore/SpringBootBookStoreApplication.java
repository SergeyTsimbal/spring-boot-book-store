package com.example.springbootbookstore;

import com.example.springbootbookstore.model.Book;
import com.example.springbootbookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBookStoreApplication {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                Book book = new Book();
                book.setTitle("Title");
                book.setAuthor("Author");
                book.setIsbn("123456789");
                book.setPrice(new BigDecimal("19.99"));
                book.setDescription("Description");
                book.setCoverImage("image.jpg");
                bookService.save(book);
                System.out.println(bookService.findAll());
            }
        };
    }
}
