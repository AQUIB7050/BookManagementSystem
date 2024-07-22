package com.bootrestbook.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.bootrestbook.bootrestbook.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
