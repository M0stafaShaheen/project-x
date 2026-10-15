package com.example.demo.service;

import java.util.List;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository  ; 
	
	
	public List<book> getAll() { 
		 return bookRepository.findAll() ; 
	}
	
	public book addBook (book book) { 
		return bookRepository.save(book);
	}

}
