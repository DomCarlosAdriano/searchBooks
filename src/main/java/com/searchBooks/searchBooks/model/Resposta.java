package com.searchBooks.searchBooks.model;

public class Resposta {


    private String nameAutor;
    private String birth_year;
    private String death_year;
    private String titleBook;
    private String languages;
    private String download_count;

    public Resposta(String nameAutor,String birth_year, String death_year, String titleBook,  String languages, String download_count){
        this.nameAutor = nameAutor;
        this.birth_year = birth_year;
        this.death_year = death_year;
        this.titleBook = titleBook;
        this.languages = languages;
        this.download_count = download_count;

    }

    public String getNameAutor() {
        return nameAutor;
    }

    public void setNameAutor(String nameAutor) {
        this.nameAutor = nameAutor;
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

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }


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
}
