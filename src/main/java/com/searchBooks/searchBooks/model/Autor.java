package com.searchBooks.searchBooks.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_year")
    private String birth_year;

    @Column(name = "death_year")
    private String death_year;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> livros = new ArrayList<>();

    public Autor(){}
    public Autor(String authors, String birthYear, String deathYear) {
        this.name = authors;
        this.birth_year = birthYear;
        this.death_year = deathYear;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getDeath_year() {
        return death_year;
    }

    public void setDeath_year(String death_year) {
        this.death_year = death_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getLivros() {
        return livros;
    }

    public void setLivros(List<Book> livros) {
        this.livros = livros;
    }
}
