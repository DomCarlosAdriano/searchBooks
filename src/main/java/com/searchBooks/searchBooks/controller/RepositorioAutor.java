package com.searchBooks.searchBooks.controller;

import com.searchBooks.searchBooks.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioAutor extends JpaRepository<Autor, Long> {
}
