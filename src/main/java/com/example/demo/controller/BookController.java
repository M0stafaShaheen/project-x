package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.book;
import com.example.demo.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/public/books")
public class BookController {
	
	@Autowired
	BookService bookService ; 

	@GetMapping("/getAll")
	public List<book> getMethodName() {
		return bookService.getAll() ; 
	}
	    @PostMapping("/addBook")
	    public String addBook(@Valid @RequestBody book book) {
	    	bookService.addBook(book);
	    	return("book added successfully") ; 
	    }
	    
	    @PutMapping("/updateBook")
	    public String putMethodName(@RequestBody book book) {
	    	return ("book updated successfully");
	    }
	    
	    @PatchMapping("/updateBook")
	    public String updateBook(@RequestBody book book) { 
	    	return ("book updated successfully") ; 
	    }
	    
	    @GetMapping ("/hello")
	    @Operation(
	            summary = "Get a greeting",
	            description = "Returns a welcome message"
	        )
	    public String Hello () { 
	    	return ("Hello") ; 
	    }
	    
	
}
