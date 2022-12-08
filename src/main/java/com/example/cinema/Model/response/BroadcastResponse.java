package com.example.cinema.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BroadcastResponse {
        private String title;
        private LocalDate date;
        private LocalTime time;
        private Integer room;
}
