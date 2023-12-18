package com.example.app1.controllers;

import com.example.app1.Services.ClientService;
import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    private ClientRepository repoClient;
    private ClientService clientService;

    public ClientController(ClientService service) {
        this.clientService = service;

    }

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
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        client.setId(-1);//Al ponerle un id no valido si se le inserta un cliente con un id repetido
        //este se le autogenera un id nuevo
        var c = repoClient.save(client);
        return ResponseEntity.ok(c);
    }

    @PutMapping(path = "/")  //PUT : /client
    public ResponseEntity<Void> update(@RequestBody Client client) {
        if (!repoClient.existsById(client.getId())) {
            return ResponseEntity.notFound().build();
            //throw new RuntimeException("No existe el cliente con el id: " + client.getId());
        }
        repoClient.save(client);
        return ResponseEntity.ok(null);
    }

    //Patch actualiza determinadas cosas
    //Put actualiza todo lo que le llega
    //
    @PatchMapping(path = "/")  //PATCH : /client
    public ResponseEntity<Void> patch(@RequestBody Client client) {
        try {
            clientService.patch(client);

        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(path = "")//DELETE: /client?if=1
    public void delete(@RequestParam(defaultValue = "0") int id) {
        repoClient.deleteById(id);
    }
}
//asdfasdfasdfasdf