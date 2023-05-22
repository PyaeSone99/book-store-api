package com.example.bookstoreapi;

import com.example.bookstoreapi.dao.CategoryDao;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootApplication
public class BookStoreApiApplication {
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    @Bean @Profile("h2")
    public ApplicationRunner runner(){
        return args -> {
            Category c1 = new Category();
            c1.setName("Historical");
            Category c2 = new Category();
            c2.setName("Tragic");
            Category c3 = new Category();
            c3.setName("Comedy");

            Book b1 = new Book("World War Z",23.5, LocalDate.of(2016,3,21),"Sun","https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg","Thomas");
            Book b2 = new Book("1776",30.5, LocalDate.of(1976,4,22),"Wed","https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg","Tom");
            Book b3 = new Book("The curse of the black pearl",40.5, LocalDate.of(2003,6,2),"Pirates of the Caribbean","https://m.media-amazon.com/images/I/513JQ6Cn1mL.jpg","Jack Sparrow");
            Book b4 = new Book("Dead Man tell no tales",33.5, LocalDate.of(2017,1,12),"Pirates of the Caribbean","https://m.media-amazon.com/images/I/513JQ6Cn1mL.jpg","Jack Sparrow");
            Book b5 = new Book("At world end",33.5, LocalDate.of(2017,1,12),"Pirates of the Caribbean","https://m.media-amazon.com/images/I/513JQ6Cn1mL.jpg","Jack Sparrow");
            Book b6 = new Book("Dead man chest",33.5, LocalDate.of(2017,1,12),"Pirates of the Caribbean","https://m.media-amazon.com/images/I/513JQ6Cn1mL.jpg","Jack Sparrow");
            c1.addBook(b1);
            c1.addBook(b2);
            c2.addBook(b6);
            c2.addBook(b4);
            c3.addBook(b3);
            c3.addBook(b5);

            categoryDao.save(c1);
            categoryDao.save(c2);
            categoryDao.save(c3);
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApiApplication.class, args);
    }

}
