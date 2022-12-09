package com.example.cinema.Model;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String title;

    private String category;

    private String duration;

    @Column(length = 500)
    private String image_url;

    @Column(length = 500)
    private String synopsis;

}
