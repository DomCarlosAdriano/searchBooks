package com.searchBooks.searchBooks.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchBooks.searchBooks.model.Autor;
import com.searchBooks.searchBooks.model.Book;
import com.searchBooks.searchBooks.model.Resposta;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Search {



    Resposta resposta;
    private String title;
    private String authors;
    private String languages;
    private String download_count;

    public Resposta searchAPI(String nome){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://gutendex.com/books/?search="+ nome)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();


            JsonNode root = mapper.readTree(response.body());
            JsonNode results = root.get("results").get(0);

            String authors = results.get("authors").get(0).get("name").asText();
            String birth_year = results.get("authors").get(0).get("birth_year").asText();
            String death_year = results.get("authors").get(0).get("death_year").asText();
            String title = results.get("title").asText();
            String languages =  results.get("languages").get(0).asText();
            String download_count =  results.get("download_count").asText();



           resposta = new Resposta(authors, birth_year, death_year, title, languages, download_count);



        } catch (Exception e){
            throw new RuntimeException(e.getMessage());

        }

        return resposta;
    }



}
