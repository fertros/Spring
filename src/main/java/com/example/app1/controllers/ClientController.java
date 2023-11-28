package com.example.app1.controllers;

import com.example.app1.entities.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @RequestMapping(path = "") //......./client/all
    public List<Client> all() {
        return List.of(
                new Client(1,"juan"),
                new Client(2,"pedro"),
                new Client(3,"maria")
        );
    }

    @RequestMapping(path = "/{id:\\d{1,5}}") //......./client
    public Client select(@PathVariable("id") int codigo) {
        return new Client(codigo,"juan");
    }
}
