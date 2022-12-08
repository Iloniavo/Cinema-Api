package com.example.cinema.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column()
    private String title;

    @Column()
    private String category;

    @Column
    private String duration;

    @Column(length = 500)
    private String image_url;

    @Column(length = 500)
    private String synopsis;

}
