package com.challenge.entity;

import com.challenge.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {

    @Id
    @Column
    private String title;
    @Column
    private LocalDate releaseDate;
    @Column
    private Double rank;
    @Column
    private Long revenue;

    public MovieDTO toMovieDTO() {
        return new MovieDTO(title, releaseDate, rank, revenue);
    }
}
