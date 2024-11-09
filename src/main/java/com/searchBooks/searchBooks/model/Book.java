package com.searchBooks.searchBooks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "livros")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


    @ManyToOne
    private Autor authors;

    @Column(name = "languages")
    private String languages;

    @Column(name = "download_count")
    private String download_count;




    public Book(){}
    public Book(String title, String languages, String downloadCount) {
        this.title = title;
        this.languages = languages;
        this.download_count = downloadCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //****************************************
    public Autor getAuthors() {
        return authors;
    }

    public void setAuthors(Autor authors) {
        this.authors = authors;
    }
    //****************************************



    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getDownload_count() {
        return download_count;
    }

    public void setDownload_count(String download_count) {
        this.download_count = download_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
