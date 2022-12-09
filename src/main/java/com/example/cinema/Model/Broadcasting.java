package com.example.cinema.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Broadcasting implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Room room;

    private LocalDate date;

    private LocalTime time;

}
