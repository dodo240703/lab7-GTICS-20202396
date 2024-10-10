package com.example.lab7gtics20202396.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

}