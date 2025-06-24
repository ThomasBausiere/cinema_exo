package org.example.cine.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cine.dto.MovieResponseDto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private String duration;
    private String category;
    @ManyToOne
    @JoinColumn(name = "film_director_id")
    private FilmDirector filmDirector;

    public MovieResponseDto entityToDto(){
        return MovieResponseDto.builder()
                .id(this.getId())
                .name(getName())
                .releaseDate(getReleaseDate())
                .description(getDescription())
                .duration(getDuration())
                .category(getCategory())
                .filmDirector(getFilmDirector())
                .build();
    }
}
