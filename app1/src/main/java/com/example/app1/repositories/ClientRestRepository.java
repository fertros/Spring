package com.example.app1.repositories;

import com.example.app1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "rest",collectionResourceRel = "client")
public interface ClientRestRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByName(String name);
}
