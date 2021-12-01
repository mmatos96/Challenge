package com.challenge.service;

import com.challenge.dto.MovieDTO;
import com.challenge.entity.Movie;
import com.challenge.exceptions.BadRequestException;
import com.challenge.exceptions.MovieNotCreatedException;
import com.challenge.exceptions.MovieNotFoundException;
import com.challenge.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(Movie::toMovieDTO).collect(Collectors.toList());
    }

    public MovieDTO getMovie(String name) throws MovieNotFoundException {
        return movieRepository.findByTitle(name)
                .orElseThrow(() -> new MovieNotFoundException(String.format("Could not find any movie with the name %s", name)))
                .toMovieDTO();
    }

    public MovieDTO createMovie(MovieDTO movieDTO) throws BadRequestException, MovieNotCreatedException {
        if(movieRepository.existsByTitle(movieDTO.getTitle()))
            throw new MovieNotCreatedException(String.format("The movie %s already exits", movieDTO.getTitle()));

        validateRequest(movieDTO);

        Movie movie = movieRepository.save(movieDTO.toMovie());
        return movie.toMovieDTO();
    }

    public MovieDTO updateMovie(MovieDTO movieDTO) throws BadRequestException, MovieNotFoundException {
        validateRequest(movieDTO);

        Movie movie = getMovie(movieDTO.getTitle()).toMovie();
        movie.setRank(movieDTO.getRank());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setRevenue(movieDTO.getRevenue());

        movie = movieRepository.save(movie);

        return movie.toMovieDTO();
    }

    public Boolean deleteMovie(String name) throws MovieNotFoundException {
        Movie movie = getMovie(name).toMovie();
        movieRepository.delete(movie);
        return true;
    }

    private void validateRequest(MovieDTO movieDTO) throws BadRequestException {
        if(movieDTO.getTitle() == null || movieDTO.getTitle().isEmpty())
            throw new BadRequestException("Movie title can't be empty");
        if(movieDTO.getRank() == null || movieDTO.getRank() < 0 || movieDTO.getRank() > 10)
            throw new BadRequestException("Movie rank can't be empty and must be between 0 and 10");
        if(movieDTO.getRevenue() < 0)
            throw new BadRequestException("Movie revenue can't be empty and must be equal greater than 0");
        if(movieDTO.getReleaseDate() == null)
            throw new BadRequestException("Release date can't be empty");
    }
}
