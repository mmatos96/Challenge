package com.challenge.entity;

import com.challenge.dto.MovieDTO;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {

    @Id
    @Column
    @NonNull
    private String title;
    @Column
    @NonNull
    private Date releaseDate;
    @Column
    @NonNull
    private Double rank;
    @Column
    @NonNull
    private Long revenue;

    public MovieDTO toMovieDTO() {
        return new MovieDTO(title, releaseDate, rank, revenue);
    }
}
