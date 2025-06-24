package org.example.cine.controller;


import org.example.cine.dto.FilmDirectorResponseDto;
import org.example.cine.dto.MovieResponseDto;
import org.example.cine.service.FilmDirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/catalogue/")
public class FilmDirectorController {

    private final FilmDirectorService filmDirectorService;

    public FilmDirectorController(FilmDirectorService filmDirectorService) {
        this.filmDirectorService = filmDirectorService;
    }

    @GetMapping("/realisateurs")
    public ResponseEntity<List<FilmDirectorResponseDto>> getAll(){
        return ResponseEntity.ok(filmDirectorService.findAll());
    }

    @GetMapping("/realisateur/{id}")
    public ResponseEntity<FilmDirectorResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(filmDirectorService.findById(id));
    }
}
