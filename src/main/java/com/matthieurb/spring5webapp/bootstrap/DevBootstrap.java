package com.matthieurb.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.matthieurb.spring5webapp.model.Author;
import com.matthieurb.spring5webapp.model.Book;
import com.matthieurb.spring5webapp.model.Publisher;
import com.matthieurb.spring5webapp.repositories.AuthorRepository;
import com.matthieurb.spring5webapp.repositories.BookRepository;
import com.matthieurb.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Publisher pub1 = new Publisher("Pub1","45 Rue Machin");
		Book ddd = new Book("Domain Driven Design","1234",pub1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		publisherRepository.save(pub1);
		bookRepository.save(ddd);

		
		Author rod = new Author("Rod", "Johnoson");
		Publisher pub2 = new Publisher("Pub2","45 Rue Machin");
		Book noEJB = new Book("J2EE development without EJB","23444",pub2);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		publisherRepository.save(pub2);
		bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

}
