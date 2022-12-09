package com.example.cinema.Controller;

import com.example.cinema.Controller.mapper.BroadcastRestMapper;
import com.example.cinema.Model.request.BroadcastRequest;
import com.example.cinema.Model.response.BroadcastResponse;
import com.example.cinema.Service.BroadcastingService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@AllArgsConstructor
public class BroadcastingController {
    private final BroadcastingService broadcastingService;
    private final BroadcastRestMapper mapper;
    /*
    TODO-1: Map all controllers

     */

    @GetMapping("/broadcasts")
    public List<BroadcastResponse> getAllBroadcasting(@RequestParam Integer page, @RequestParam Integer pageSize){
        return broadcastingService.getAllBroadcasting(page, pageSize)
                .stream()
                .map(mapper::toRest)
                .toList();
    }

    @GetMapping("/broadcast/{id}")
    public BroadcastResponse getBroadcastingById(@PathVariable Integer id){
        return mapper.toRest(broadcastingService.getBroadcastingById(id));
    }

    @GetMapping("/broadcasts/{date}")
    public List<BroadcastResponse> getBroadcastingByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date ){
        return broadcastingService.getAllBroadcastingByDate(date)
                .stream()
                .map(mapper::toRest)
                .toList();
    }
    @GetMapping("/broadcasts/movies/{title}")
    public List<BroadcastResponse> getByTitle(@PathVariable String title){
        return broadcastingService.getBroadcastingByTitle(title)
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }
    @PutMapping("/broadcasts")
    public List<BroadcastResponse> createOrUpdateBroadcasting(@RequestBody List<BroadcastRequest> bc){
        return broadcastingService.updateBroadcasting(bc.stream().map(mapper::toCreateOrUpdate).collect(Collectors.toList()))
                .stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/broadcasts")
    public BroadcastResponse addBroadcasting(@RequestBody BroadcastRequest bc){
        return mapper.toRest(broadcastingService.addBroadcasting(mapper.toCreateOrUpdate(bc)));
    }

    @DeleteMapping("/broadcast/{id}")
    public String deleteBroadcastingById(@PathVariable Integer id){
        broadcastingService.deleteBroadcstingById(id);
        return "Delete Successfully";
    }

}
