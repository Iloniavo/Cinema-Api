package com.example.cinema.Repository;

import com.example.cinema.Model.Broadcasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BroadcastRepository extends JpaRepository<Broadcasting,Integer>{
    List<Broadcasting> findBroadcastingByDate(LocalDate date);
    @Query(value = "SELECT bc FROM Broadcasting bc INNER JOIN Movie mv ON mv.id = bc.movie and mv.title=:titre")
    List<Broadcasting> findByTitle(String titre);
}