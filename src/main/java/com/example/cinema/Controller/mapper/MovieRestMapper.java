package com.example.cinema.Controller.mapper;


import com.example.cinema.Model.Movie;
import com.example.cinema.Model.request.MovieRequest;
import org.springframework.stereotype.Component;

@Component
public class MovieRestMapper {
    public MovieRequest toRest(Movie domain){
        return MovieRequest.builder()
                .title(domain.getTitle())
                .category(domain.getCategory())
                .duration(domain.getDuration())
                .image_url(domain.getImage_url())
                .synopsis(domain.getSynopsis())
                .build();
    }

    public Movie toCreate(MovieRequest domain){
        return Movie.builder()
                .title(domain.getTitle())
                .category(domain.getCategory())
                .duration(domain.getDuration())
                .image_url(domain.getImage_url())
                .synopsis(domain.getSynopsis())
                .build();
    }
}
