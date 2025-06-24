package org.example.cine.dto;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cine.entity.FilmDirector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilmDirectorReceiveDto {

    @Size(min = 3, max=25)
    private String firstName;
    @Size(min = 3, max=25)
    private String lastName;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    private String birthDate;
    @Size(min = 3, max=25)
    private String country;

    public FilmDirector dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return FilmDirector.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .birthDate(LocalDate.parse(getBirthDate(),dateTimeFormatter))
                .country(getCountry())
                .build();

    }
}
