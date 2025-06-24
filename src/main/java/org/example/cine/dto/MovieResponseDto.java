package org.example.cine.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cine.entity.FilmDirector;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MovieResponseDto {

    private UUID id;
    private String name;
    private LocalDate releaseDate;
    private String description;
    private String duration;
    private String category;
    private FilmDirector filmDirector;
}
