package com.example.app1.configs;

import com.example.app1.entities.Client;
import com.example.app1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring busca beans en clases con anotaciones para que busque los Beans
@Configuration
public class Setup {
    @Autowired
    private ClientRepository repo;
    @Bean
    //comnnand line es una interfaz funcional para funciones lambda
    public CommandLineRunner init(){
        return args -> {
            System.out.println("Inicializacion base de datos");
            repo.save(new Client("Pedro"));
            repo.save(new Client("Ana"));
            repo.save(new Client("Juan"));

            System.out.println(repo.findAll());
        };
    }
}
