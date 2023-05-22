package com.example.bookstoreapi.dao;

import com.example.bookstoreapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
}
