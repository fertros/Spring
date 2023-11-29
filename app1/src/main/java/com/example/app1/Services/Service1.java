package com.example.app1.Services;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//Anotacion @Repository
//Anotacio @Service
@Service
//@Scope("prototype")
public class Service1 {
    @PostConstruct
    public void init() {
        System.out.println("Se ha creado el Bean");
    }
    public String algo() {
        System.out.println("Se ha ejecutado algo()");
        return "Hola";
    }
}
