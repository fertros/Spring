package com.example.appjpa.config;

import com.example.appjpa.entity.Author;
import com.example.appjpa.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.appjpa.repository.AuthorRepository;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.LocalDate;

@Configuration
public class initConfig {
    @Bean
    public CommandLineRunner init(AuthorRepository repo) {
        //Este bean es una interfaz funcional que tiene un argumento y no devuelve nada
        return args -> {
            //Aqui se pone el codigo de autentificacion
            var auth1 = new Author("Juan");
            var book1 = new Book(0,"libro1", LocalDate.now(),auth1);
            auth1.getBooks().add(book1);
            repo.saveAndFlush(auth1);

            auth1 = new Author("Pedro");
            repo.saveAndFlush(auth1);
            //var response = repo.findById(1).get();
            //response.getBooks().size();
            //System.out.println(response);

            /*var client = WebClient.create("/author");
            client.get()
                    .retrieve()
                    .bodyToFlux(Author.class)
                    .delayElements(Duration.ofSeconds(5))
                    .toStream()
                    .forEach(a -> System.out.println(a));*/
        };
    }
}
