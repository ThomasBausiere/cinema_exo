package org.example.cine.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cine.dto.FilmDirectorResponseDto;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmDirector {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;

    public FilmDirectorResponseDto entityToDto(){
        return FilmDirectorResponseDto.builder()
                .id(this.getId())
                .firstName(getFirstName())
                .lastName(getLastName())
                .birthDate(getBirthDate())
                .country(getCountry())
                .build();
    }
}
