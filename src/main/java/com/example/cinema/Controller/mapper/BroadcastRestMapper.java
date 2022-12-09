package com.example.cinema.Controller.mapper;

import com.example.cinema.Model.Broadcasting;
import com.example.cinema.Model.Movie;
import com.example.cinema.Model.Room;
import com.example.cinema.Model.request.BroadcastRequest;
import com.example.cinema.Model.response.BroadcastResponse;
import com.example.cinema.Service.MovieService;
import com.example.cinema.Service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BroadcastRestMapper {
    private final MovieService movieService;
    private final RoomService roomService;

    public BroadcastResponse toRest(Broadcasting domain){
        return BroadcastResponse.builder()
                .date(domain.getDate())
                .time(domain.getTime())
                .title(domain.getMovie().getTitle())
                .room(domain.getRoom().getId())
                .build();
    }

    public Broadcasting toCreateOrUpdate(BroadcastRequest domain){
        Movie movie = movieService.getMovieById(domain.getMovie_id());
        Room room = roomService.getRoomById(domain.getRoom_id());
        return Broadcasting.builder()
                .date(domain.getDate())
                .time(domain.getTime())
                .movie(movie)
                .room(room)
                .build();
    }
}
