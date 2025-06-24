package org.example.cine.controller;


import org.example.cine.dto.MovieResponseDto;
import org.example.cine.entity.Movie;
import org.example.cine.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/catalogue/")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/films")
    public ResponseEntity<List<MovieResponseDto>> getAll(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<MovieResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(movieService.findById(id));
    }



}
