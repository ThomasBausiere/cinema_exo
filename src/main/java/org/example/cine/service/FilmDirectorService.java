package org.example.cine.service;

import org.example.cine.dto.FilmDirectorReceiveDto;
import org.example.cine.dto.FilmDirectorResponseDto;
import org.example.cine.entity.FilmDirector;
import org.example.cine.exception.NotFoundException;
import org.example.cine.repository.FilmDirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmDirectorService implements BaseService<FilmDirectorResponseDto, FilmDirectorReceiveDto> {
    private final FilmDirectorRepository filmDirectorRepository;

    public FilmDirectorService(FilmDirectorRepository filmDirectorRepository) {
        this.filmDirectorRepository = filmDirectorRepository;
    }

    @Override
    public FilmDirectorResponseDto save(FilmDirectorReceiveDto filmDirectorReceiveDto) {
        return filmDirectorRepository.save(filmDirectorReceiveDto.dtoToEntity()).entityToDto();
    }

    @Override
    public FilmDirectorResponseDto findById(UUID id) {
        return filmDirectorRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    @Override
    public List<FilmDirectorResponseDto> findAll() {
        return filmDirectorRepository.findAll().stream().map(FilmDirector::entityToDto).toList();
    }

    @Override
    public FilmDirectorResponseDto update(UUID id, FilmDirectorReceiveDto filmDirectorReceiveDto) {

            FilmDirector directorFound = filmDirectorRepository.findById(id).orElseThrow(NotFoundException::new);
            FilmDirector directorGet =filmDirectorReceiveDto.dtoToEntity();
                directorFound.setFirstName(directorGet.getFirstName());
                directorFound.setLastName(directorGet.getLastName());
                directorFound.setCountry(directorGet.getCountry());
                directorFound.setBirthDate(directorGet.getBirthDate());
            return filmDirectorRepository.save(directorFound).entityToDto();

    }


    @Override
    public void deleteById(UUID id) {
        filmDirectorRepository.deleteById(id);
    }
}
