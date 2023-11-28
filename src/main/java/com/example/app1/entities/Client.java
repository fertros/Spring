package com.example.app1.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

//@Data//Genera los getter y setter de todos los atributos
@Entity
@AllArgsConstructor//Genera el constructor con todos los atributos
@NoArgsConstructor//Genera el contructor vacio
@ToString()
@EqualsAndHashCode(of =  {"id"})
public class Client {
    @Id @Getter @Setter private  int id;
    @Getter @Setter private  String name;


}
