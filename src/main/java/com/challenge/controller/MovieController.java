package com.challenge.controller;

import com.challenge.dto.MovieDTO;
import com.challenge.exceptions.BadRequestException;
import com.challenge.exceptions.MovieNotCreatedException;
import com.challenge.exceptions.MovieNotFoundException;
import com.challenge.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{name}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable final String name) throws MovieNotFoundException {
        return ResponseEntity.ok(movieService.getMovie(name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable final String name) throws MovieNotFoundException {
        return ResponseEntity.ok(movieService.deleteMovie(name));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody final MovieDTO movieDTO) throws BadRequestException, MovieNotCreatedException {
        return ResponseEntity.ok(movieService.createMovie(movieDTO));
    }

    @PutMapping
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody final MovieDTO movieDTO) throws BadRequestException, MovieNotFoundException {
        return ResponseEntity.ok(movieService.updateMovie(movieDTO));
    }


}
