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
public class FilmDirectorResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;


}
