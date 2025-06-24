package org.example.cine.repository;

import org.example.cine.entity.FilmDirector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmDirectorRepository extends JpaRepository<FilmDirector, UUID> {
}
