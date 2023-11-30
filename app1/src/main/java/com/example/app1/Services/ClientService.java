package com.example.app1.Services;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ClientService implements IClientService {
    private final ClientRepository repo;
    @Autowired
    public ClientService(final ClientRepository repo){
        this.repo = repo;
    }

    @Override
    public void patch(Client client){
        var optional = repo.findById(client.getId());
        if(optional.isEmpty()) {
            throw new RuntimeException("No existe el cliente con el id: " + client.getId());
        }
        var c = optional.get();
        if(client.getName()!= null) {
            c.setName(client.getName());
        }
        repo.save(c);
    }
}
