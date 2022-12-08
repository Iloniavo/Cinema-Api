package com.example.cinema.Controller;

import com.example.cinema.Model.Broadcasting;
import com.example.cinema.Service.BroadcastingService;
import com.example.cinema.Service.PostBcRequest;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class BroadcastingController {
    private final BroadcastingService broadcastingService;

    public BroadcastingController(BroadcastingService broadcastingService) {
        this.broadcastingService = broadcastingService;
    }

    @GetMapping("/broadcasts")
    public List<Broadcasting> getAllBroadcastings(@RequestParam Integer page,@RequestParam Integer pageSize){
        return broadcastingService.getAllBroadcasting(page, pageSize);
    }

    @GetMapping("/broadcast/{id}")
    public Broadcasting getBroadcastingById(@PathVariable Integer id){
        return broadcastingService.getBroadcastingById(id);
    }

    @GetMapping("/broadcasts/{date}")
    public List<Broadcasting> getBroadcastingsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date ){
        return broadcastingService.getAllBroadcastingByDate(date);
    }
    @GetMapping("/broadcasts/movies/{title}")
    public List<Broadcasting> getByTitle(@PathVariable String title){
        return broadcastingService.getBroadcastingByTitle(title);
    }
    @PutMapping("/broadcasts")
    public List<Broadcasting> createOrUpdateBroadcasting(@RequestBody List<Broadcasting> bc){
        return broadcastingService.createOrUpdateBroadcasting(bc);
    }

    @PostMapping("/broadcasts")
    public Broadcasting addBroadcasting(@RequestBody PostBcRequest bc){
        return broadcastingService.addBroadcasting(bc);
    }

    @DeleteMapping("/broadcast/{id}")
    public void deleteBroadcastingById(@PathVariable Integer id){
        broadcastingService.deleteBroadcstingById(id);
    }

}
