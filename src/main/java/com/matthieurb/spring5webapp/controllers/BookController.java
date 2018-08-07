package com.matthieurb.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthieurb.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	private BookRepository bookrepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookrepository = bookRepository;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model){
		model.addAttribute("books",bookrepository.findAll());
		
		return "books";
	}
	
}
