package com.example.app1.repositories;

import com.example.app1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

