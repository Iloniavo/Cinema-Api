package com.example.cinema.Service;

import com.example.cinema.Model.Movie;
import com.example.cinema.Repository.BroadcastRepository;
import com.example.cinema.Repository.MovieRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final BroadcastRepository broadcastRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public List<Movie> createOrUpdateMovie(List<Movie> mv){
        return movieRepository.saveAll(mv);
    }

    public void deleteMovieById(Integer id){
        movieRepository.deleteById(id);
    }


    public void addMovie(Movie mv){
        movieRepository.save(mv);
    }

    public Movie getMovieById(Integer id){
        return movieRepository.findById(id).get();
    }

    public List<Movie> getMoviesByTitle(String title){
        return movieRepository.findMovieByTitle(title);
    }

    public List<Movie> getMoviesByCategory(String category){ return movieRepository.findByCategory(category); }


}
