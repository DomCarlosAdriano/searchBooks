package com.searchBooks.searchBooks.view;

import com.searchBooks.searchBooks.controller.RepositorioAutor;
import com.searchBooks.searchBooks.controller.Search;
import com.searchBooks.searchBooks.model.Autor;
import com.searchBooks.searchBooks.model.Book;
import com.searchBooks.searchBooks.model.Resposta;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    //private Repositorio repositorio;
    private RepositorioAutor repositorioAutor;
    private Scanner leitura = new Scanner(System.in);
    private Search search = new Search();
    int x;

    public Principal(RepositorioAutor repositorioAutor) {
        this.repositorioAutor = repositorioAutor;
    }


    public void exibeMenu() {
        var opcao = -1;

        while (opcao!= 0) {
            var menu = """
                    *** Escolha o numero da sua opção ***                    
                    
                    1- Buscar livro pelo titulo
                    2- listar livros registrados
                    3- Listar autores registrados
                    4- Listar autores vivios em um determinado ano
                    5- Listar livros em um determinado idioma
                    
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEmUmDeterminadoAno();
                    break;
                case 5:
                    pesquisarPorIdioma();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarPorIdioma() {
        System.out.println("digite a abreviação do idioma (ex: pt, en): ");
        String idioma = leitura.nextLine();

        List<Autor> autores = repositorioAutor.findAll();

        for(int x = 0; x < autores.size(); x++){


          List<Book> list =  autores.get(x).getLivros().stream()
                    .filter(i -> Objects.equals(i.getLanguages(), idioma))
                    .collect(Collectors.toList());

          list.forEach(e -> exibrLivro(e.getTitle(),e.getAuthors().getName(), e.getLanguages(), e.getDownload_count()));


        }
    }


    private void listarAutoresVivosEmUmDeterminadoAno() {
        System.out.println("Digite o ano:");
        int ano = leitura.nextInt();

        List<Autor> autores = repositorioAutor.findAll();
        for (int i = 0; i < autores.size(); i++){
            try {
                x = Integer.parseInt(autores.get(i).getBirth_year());
                exibrAutor(autores.get(i).getName(), autores.get(i).getBirth_year(), autores.get(i).getDeath_year(), autores.get(i).getLivros());
            } catch (Exception e){
                x = 0000;
            }
        }


    }

    private void listarAutoresRegistrados() {
        List<Autor> autors = repositorioAutor.findAll();
        autors.forEach(a -> exibrAutor( a.getName(), a.getBirth_year(), a.getDeath_year(), a.getLivros() ));

    }

    private void listarLivrosRegistrados() {
        List<Autor> autors = repositorioAutor.findAll();
        autors.forEach(a -> a.getLivros().forEach(e -> exibrLivro(e.getTitle(),e.getAuthors().getName(), e.getLanguages(), e.getDownload_count())));


    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Digite o nome do livro que você esta buscando:");
        String nameBook = leitura.nextLine().replaceAll(" ", "%20");

        Resposta repostaApi = search.searchAPI(nameBook);

        Book books = new Book(repostaApi.getTitleBook(), repostaApi.getLanguages(), repostaApi.getDownload_count());
        Autor autor = new Autor(repostaApi.getNameAutor(), repostaApi.getBirth_year(), repostaApi.getDeath_year());

        books.setAuthors(autor);
        autor.getLivros().add(books);

        repositorioAutor.save(autor);



        exibrLivro(repostaApi.getTitleBook(), repostaApi.getNameAutor() ,repostaApi.getLanguages(), repostaApi.getDownload_count() );

    }



    private void exibrLivro(String title, String authors, String languages, String downloadCount){
        System.out.println("\n*********** LIVRO ***********\n");
        System.out.println("Titulo: " + title);
        System.out.println("Autor: " + authors);
        System.out.println("Idioma: " + languages);
        System.out.println("Numero de download: " + downloadCount);
        System.out.println("\n*****************************");
    }

    private void exibrAutor(String name, String born, String dead, List<Book> livros ){
        System.out.println("\n*********** AUTOR ***********\n");
        System.out.println("Nome do autor: " + name);
        System.out.println("Data de nascimento: " + born);
        System.out.println("Data de falecimento: " + dead);
        System.out.println("Livros:");
        livros.forEach(a -> System.out.println(" - " + a.getTitle()));
        System.out.println("\n*****************************");
    }

}

