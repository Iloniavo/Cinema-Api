package com.example.cinema.Controller;

import com.example.cinema.Controller.mapper.MovieRestMapper;
import com.example.cinema.Model.request.MovieRequest;
import com.example.cinema.Service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin
public class MovieController {

    private final MovieService movieService;
    private final MovieRestMapper mapper;
    @GetMapping("/movies")
    public List<MovieRequest> getAllMovies(@RequestParam Integer page, @RequestParam Integer pageSize){
        return movieService.getAllMovies(page, pageSize)
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @GetMapping("/movies/{title}")
    public List<MovieRequest> getMoviesByTitle(@PathVariable String title){
        return movieService.getMoviesByTitle(title)
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }


    @GetMapping("/movie/{id}")
    public MovieRequest getMovieById(@PathVariable Integer id){
        return mapper.toRest(movieService.getMovieById(id)) ;
    }

    @GetMapping("/categories/{category}")
    public List<MovieRequest> getMoviesByCategory(@PathVariable  String category){
        return movieService.getMoviesByCategory(category)
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovieById(@PathVariable Integer id){
        movieService.deleteMovieById(id);
        return "Delete Successfully";
    }

    @PostMapping("/movies")
    public List<MovieRequest> createMovies(@RequestBody List<MovieRequest> movies){
        return movieService.createMovies(movies.stream().map(mapper::toCreateOrUpdate).collect(Collectors.toList()))
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @PutMapping("/movies")
    public List<MovieRequest> updateMovies(@RequestBody  List<MovieRequest> mv){
        return movieService.updateMovies(mv.stream().map(mapper::toCreateOrUpdate).collect(Collectors.toList()))
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }


}
