package com.example.cinema.Repository;

import com.example.cinema.Model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT mv FROM Movie mv WHERE mv.title like %:title%")
    List<Movie> findMovieByTitle(String title);
    @Query(value="SELECT mv FROM Movie mv WHERE mv.category like %:category%")
    List<Movie> findByCategory(String category);

}
