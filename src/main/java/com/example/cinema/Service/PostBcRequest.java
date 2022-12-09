package com.example.cinema.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBcRequest {
    public String title;
    public LocalDate date;
    public LocalTime time;
    public Integer movie_id;
    public Integer room_id;
}
