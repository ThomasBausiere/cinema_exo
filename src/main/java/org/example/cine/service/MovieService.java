package org.example.cine.service;

import org.example.cine.dto.FilmDirectorReceiveDto;
import org.example.cine.dto.FilmDirectorResponseDto;
import org.example.cine.dto.MovieReceiveDto;
import org.example.cine.dto.MovieResponseDto;
import org.example.cine.entity.FilmDirector;
import org.example.cine.entity.Movie;
import org.example.cine.exception.NotFoundException;
import org.example.cine.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService implements BaseService<MovieResponseDto, MovieReceiveDto> {
    private final MovieRepository movieRepository;
    private final FilmDirectorService filmDirectorService;

    public MovieService(MovieRepository movieRepository, FilmDirectorService filmDirectorService) {
        this.movieRepository = movieRepository;
        this.filmDirectorService = filmDirectorService;
    }

    @Override
    public MovieResponseDto save(MovieReceiveDto movieReceiveDto) {
        return movieRepository.save(movieReceiveDto.dtoToEntity()).entityToDto();
    }

    @Override
    public MovieResponseDto findById(UUID id) {
        return movieRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    @Override
    public List<MovieResponseDto> findAll() {
        return movieRepository.findAll().stream().map(Movie::entityToDto).toList();
    }
    @Override
    public MovieResponseDto update(UUID id,MovieReceiveDto movieReceiveDto){
        Movie movieFound =movieRepository.findById(id).orElseThrow(NotFoundException::new);
        Movie movieGet = movieReceiveDto.dtoToEntity();
                    movieFound.setName(movieGet.getName());
                    movieFound.setReleaseDate(movieGet.getReleaseDate());
                    movieFound.setDescription(movieGet.getDescription());
                    movieFound.setDuration(movieGet.getDuration());
                    movieFound.setCategory(movieGet.getCategory());
                    movieFound.setFilmDirector(movieGet.getFilmDirector());
        return movieRepository.save(movieFound).entityToDto();
    }
    @Override
    public void deleteById(UUID id) {
        movieRepository.deleteById(id);
    }

//    public boolean addFilmDirector(MovieReceiveDto movieReceiveDto) {
//        FilmDirectorResponseDto filmDirectorExist = filmDirectorService.findById(movieReceiveDto.dtoToEntity().getFilmDirector().getId());
//        Movie movieExist = movieRepository.findByFilmDirector(movieReceiveDto.getFilmDirectorId());
//        if (filmDirectorExist != null && movieExist != null) {
//            movieReceiveDto.setFilmDirector(movieExist.getFilmDirector());
//        }
//        return true;
//    }

        public FilmDirector findFilmDirectorById(UUID id){
            FilmDirectorResponseDto filmDirectorFound = filmDirectorService.findById(id);
                if(filmDirectorFound != null){
                    return filmDirectorRepository
                }
        return null;
     }


}
