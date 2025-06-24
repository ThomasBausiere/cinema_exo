package org.example.cine.repository;

import org.example.cine.entity.FilmDirector;
import org.example.cine.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    Movie findByFilmDirector(FilmDirector filmDirector);
    FilmDirector findFilmDirectorById(UUID id);
}
