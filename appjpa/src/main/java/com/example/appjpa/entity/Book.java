package com.example.appjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"author"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "authorId", referencedColumnName = "id")
    private Author author;
}
