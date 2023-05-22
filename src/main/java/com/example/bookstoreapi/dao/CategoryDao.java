package com.example.bookstoreapi.dao;

import com.example.bookstoreapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
