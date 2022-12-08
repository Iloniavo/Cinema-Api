package com.example.cinema.Model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BroadcastRequest {
    private LocalDate date;
    private LocalTime time;
    private Integer movie_id;
    private Integer room_id;
}
