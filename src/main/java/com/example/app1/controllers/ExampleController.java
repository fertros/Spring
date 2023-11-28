package com.example.app1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

//@Restcontroller
@Controller //Devuelve el identificador de una pagina
@RequestMapping(path = "/example")
public class ExampleController {
    //anotaciones
    @RequestMapping(path = "hello")//http://....../example/hello
    @ResponseBody //Interpreta que el metodo solo sea un dato
    public String hello() {
        return "Hola";
    }
    @RequestMapping(path = "date")//http://....../example/date
    @ResponseBody
    public LocalDateTime localDate() {
        return LocalDateTime.now();
    }


}