package com.example.appjpa.controller;

import com.example.appjpa.entity.Author;
import com.example.appjpa.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

//@CrossOrigin(originPatterns = {})//Creas acceso a ciertos dominios para hacer consultas
@RestController
@RequestMapping("/author")
public class AuthorControler {
    private final AuthorRepository repo;

    @Value("${page.size}")
    private int pageSize;
    @Autowired
    private ObjectMapper mapper;

    //Se define un parametro de ruta
    //Injectar el repositrio
    public AuthorControler(AuthorRepository repo) {
        this.repo = repo;
    }

    @GetMapping(path = "{id}")//Hacer una consula de autor //GET /author/1
    public Author findAut(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Solicita una lista de autores
     * @param page Parametros de cadena de conosulta opcional que indica el numero de pagina contando desde 0
     *              un valor menor   a su ausencia inidi ca que se solicia los autores.
     * @return flujo de autoras
     */
    //@Operation(summary = "Solicita un alista de autores", description = "....b")
    @GetMapping(path = "")//Hacer una consula de autor //GET /author[?page=0]
    public Flux<Author> findAll(@RequestParam(defaultValue = "-1") int page) {
        if (page < 0) {
            var authors = repo.findAll();
            return Flux.fromIterable(authors).delayElements(Duration.ofSeconds(5));
        }
        var pageable = Pageable.ofSize(pageSize).withPage(page);
        var pageAuthors = repo.findAll(pageable);
        if (pageAuthors.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Pagina vacia");
        }
        return Flux.fromIterable(pageAuthors.toList());
    }
}
