package com.example.app1.controllers;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    private ClientRepository repoClient;
    //Tambien se puede usar @GetMapping
    @RequestMapping(path = "/", method = RequestMethod.GET) //......./client
    public List<Client> all() {
        return repoClient.findAll();
    }

    @GetMapping(path = "/{id:\\d{1,5}}") //......./client
    public Client select(@PathVariable("id") int codigo) {
        return repoClient.findById(codigo).get();
    }
    @PostMapping(path = "/")  //POST : /client
    public void insert(@RequestBody Client client) {
        repoClient.save(client);

    }
}
