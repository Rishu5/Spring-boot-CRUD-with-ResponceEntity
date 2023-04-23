package com.example.demo.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.crud.entity.Book;

public interface Bookcrud extends CrudRepository<Book, Integer>{

	public Book  findById(int id);
	
}
