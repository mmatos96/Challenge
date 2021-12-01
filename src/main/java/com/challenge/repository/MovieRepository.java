package com.challenge.repository;

import com.challenge.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByTitle(String name);
    List<Movie> findAllByReleaseDate(LocalDate date);

    boolean existsByTitle(String name);

}
