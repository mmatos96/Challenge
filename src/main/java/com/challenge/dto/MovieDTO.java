package com.challenge.dto;

import com.challenge.entity.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {

    private final String title;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate releaseDate;
    private final Double rank;
    private final long revenue;

    public Movie toMovie() {
        return new Movie(title, releaseDate, rank, revenue);
    }

}
