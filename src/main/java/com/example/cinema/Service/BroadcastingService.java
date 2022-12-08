package com.example.cinema.Service;

import com.example.cinema.Model.Broadcasting;
import com.example.cinema.Model.Movie;
import com.example.cinema.Model.Room;
import com.example.cinema.Repository.BroadcastRepository;
import com.example.cinema.Repository.MovieRepository;
import com.example.cinema.Repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BroadcastingService {
   private final BroadcastRepository broadcast;
   private final MovieRepository movieRepository;
   private final RoomRepository roomRepository;
   private final Broadcasting broadcasting;
   public List<Broadcasting> getAllBroadcasting(Integer page, Integer pageSize){
      Pageable pageable = PageRequest.of(page - 1, pageSize);
      return broadcast.findAll(pageable).stream().collect(Collectors.toList());
   }

   public Broadcasting addBroadcasting(PostBcRequest bc){
      Movie movie = movieRepository.findById(bc.getMovie_id()).get();
      Room room = roomRepository.findById(bc.getRoom_id()).get();
      Broadcasting broadcasting = new Broadcasting();
      broadcasting.setDate(bc.getDate());
      broadcasting.setTime(bc.getTime());
      broadcasting.setRoom(room);
      broadcasting.setMovie(movie);
      return broadcast.save(broadcasting);
   }

   public Broadcasting updateBroadcasting(Broadcasting bc){return null;}

   public Broadcasting getBroadcastingById(Integer id){
      return broadcast.findById(id).get();
   }


   public List<Broadcasting> getBroadcastingByTitle(String title){
      return broadcast.findByTitle(title);
   }
   public void deleteBroadcstingById(Integer id){
       broadcast.deleteById(id);
   }
   public List<Broadcasting> getAllBroadcastingByDate(LocalDate date){
      return broadcast.findBroadcastingByDate(date);
   }

   public List<Broadcasting> createOrUpdateBroadcasting(List<Broadcasting> bc) { return broadcast.saveAll(bc); }
}
