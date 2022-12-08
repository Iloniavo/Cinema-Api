package com.example.cinema.Controller;

import com.example.cinema.Model.Movie;
import com.example.cinema.Service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer pageSize){
        return movieService.getAllMovies(page, pageSize);
    }

    @GetMapping("/movies/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title){
        return movieService.getMoviesByTitle(title);
    }


    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable Integer id){
        return movieService.getMovieById(id);
    }

    @CrossOrigin
    @GetMapping("/categories/{category}")
    public List<Movie> getMoviesByCategory(@PathVariable  String category){ return movieService.getMoviesByCategory(category); }

    @DeleteMapping("/movie/{id}")
    public void deleteMovieById(@PathVariable Integer id){
        movieService.deleteMovieById(id);
    }

    @PostMapping("/movies")
    public List<Movie> createMovies(@RequestBody List<Movie> movies){ return movieService.createMovies(movies); }

    @PutMapping("/movies")
    public List<Movie> updateMovies(@RequestBody  List<Movie> mv){
        return movieService.updateMovies(mv);
    }


}
