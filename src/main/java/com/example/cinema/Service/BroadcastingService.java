package com.example.cinema.Service;

import com.example.cinema.Controller.mapper.BroadcastRestMapper;
import com.example.cinema.Model.Broadcasting;
import com.example.cinema.Model.Movie;
import com.example.cinema.Model.Room;
import com.example.cinema.Model.request.BroadcastRequest;
import com.example.cinema.Repository.BroadcastRepository;
import com.example.cinema.Repository.MovieRepository;
import com.example.cinema.Repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BroadcastingService {
   private final BroadcastRepository broadcastRepository;
   public List<Broadcasting> getAllBroadcasting(Integer  page, Integer pageSize){
       Pageable pageable = PageRequest.of(page - 1, pageSize);
       return broadcastRepository.findAll(pageable).stream().toList();
   }

   public Broadcasting addBroadcasting(Broadcasting bc){
     return broadcastRepository.save(bc);
   }


   public Broadcasting getBroadcastingById(Integer id){
      return broadcastRepository.getById(id);
   }


   public List<Broadcasting> getBroadcastingByTitle(String title){
      return broadcastRepository.findByTitle(title);
   }
   public void deleteBroadcstingById(Integer id){
       broadcastRepository.deleteById(id);
   }
   public List<Broadcasting> getAllBroadcastingByDate(LocalDate date){
      return broadcastRepository.findBroadcastingByDate(date);
   }

   public List<Broadcasting> updateBroadcasting(List<Broadcasting> bc) { return broadcastRepository.saveAll(bc); }
}
