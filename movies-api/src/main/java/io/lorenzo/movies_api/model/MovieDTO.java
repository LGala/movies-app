package io.lorenzo.movies_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MovieDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String title;

    private LocalDate releaseDate;

    private Double voteAverage;

    private Boolean hasVideoFormat;
}
