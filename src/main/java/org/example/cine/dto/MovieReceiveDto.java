package org.example.cine.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cine.entity.FilmDirector;
import org.example.cine.entity.Movie;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieReceiveDto {
    @Size(min = 3, max=25)
    private String name;
    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "La date dois etre au format dd-MM-yyyy")
    private String releaseDate;
    @Size(min = 3, max=25)
    private String description;
    @Size(min = 3, max=25)
    private String duration;
    @Size(min = 3, max=25)
    private String category;
    private FilmDirector filmDirector;

    public Movie dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return Movie.builder()
                .name(this.getName())
                .releaseDate(LocalDate.parse(getReleaseDate(),dateTimeFormatter))
                .description(getDescription())
                .duration(getDescription())
                .category(getCategory())
                .filmDirector(getFilmDirector())
                .build();
    }
}
