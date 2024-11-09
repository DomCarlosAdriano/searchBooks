package com.searchBooks.searchBooks;

import com.searchBooks.searchBooks.controller.RepositorioAutor;
import com.searchBooks.searchBooks.view.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchBooksApplication implements CommandLineRunner {

	@Autowired
	private RepositorioAutor repositorioAutor;

	public static void main(String[] args) {
		SpringApplication.run(SearchBooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorioAutor);
		principal.exibeMenu();


	}
}
