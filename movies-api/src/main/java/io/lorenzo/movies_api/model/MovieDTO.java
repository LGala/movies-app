package io.lorenzo.movies_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;


public class MovieDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String title;

    private LocalDate releaseDate;

    private Double voteAverage;

    private Boolean hasVideoFormat;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(final LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(final Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Boolean getHasVideoFormat() {
        return hasVideoFormat;
    }

    public void setHasVideoFormat(final Boolean hasVideoFormat) {
        this.hasVideoFormat = hasVideoFormat;
    }

}
