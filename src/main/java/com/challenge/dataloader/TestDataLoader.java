package com.challenge.dataloader;

import com.challenge.entity.Movie;
import com.challenge.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TestDataLoader implements ApplicationRunner {

    private final MovieRepository movieRepository;

    @Autowired
    public TestDataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(new Movie("The Fast and The Furious", LocalDate.parse("2001-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")),6.8, 207305509L));
        movieRepository.save(new Movie("Avatar", LocalDate.parse("2009-12-19", DateTimeFormatter.ofPattern("yyyy-MM-dd")),7.8, 2847305509L));
        movieRepository.save(new Movie("Home Alone", LocalDate.parse("1991-01-25", DateTimeFormatter.ofPattern("yyyy-MM-dd")),7.3, 476305509L));
        movieRepository.save(new Movie("About Time", LocalDate.parse("2013-10-31", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 7.8, 87100449L));
        System.out.println("All test data was loaded");
    }
}
