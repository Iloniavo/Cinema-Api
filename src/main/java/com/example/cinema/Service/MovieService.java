package com.example.cinema.Service;

import com.example.cinema.Model.Movie;
import com.example.cinema.Repository.BroadcastRepository;
import com.example.cinema.Repository.MovieRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final BroadcastRepository broadcastRepository;

    public List<Movie> getAllMovies(Integer page, Integer pageSize){
        try {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            return movieRepository.findAll(pageable).stream().collect(Collectors.toList());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
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
