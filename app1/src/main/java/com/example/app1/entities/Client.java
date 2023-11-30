package com.example.app1.entities;

import jakarta.persistence.*;
import lombok.*;

//@Data//Genera los getter y setter de todos los atributos
@Entity //@Table("Client") En caso de que se cambie el nombre de la tabla con la clase en java
@AllArgsConstructor//Genera el constructor con todos los atributos
@NoArgsConstructor//Genera el contructor vacio
@ToString()
@EqualsAndHashCode(of = {"id"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private String name;

    public int getCodigo(){
        return id;
    }
    public Client(String name) {
        this.name = name;
    }
}
