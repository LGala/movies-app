package io.lorenzo.movies_api.service;

import io.lorenzo.movies_api.domain.Movie;
import io.lorenzo.movies_api.model.MovieDTO;
import io.lorenzo.movies_api.repos.MovieRepository;
import io.lorenzo.movies_api.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findAll() {
        final List<Movie> movies = movieRepository.findAll(Sort.by("id"));
        return movies.stream()
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .toList();
    }

    public MovieDTO get(final Long id) {
        return movieRepository.findById(id)
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final MovieDTO movieDTO) {
        final Movie movie = new Movie();
        mapToEntity(movieDTO, movie);
        return movieRepository.save(movie).getId();
    }

    public void update(final Long id, final MovieDTO movieDTO) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(movieDTO, movie);
        movieRepository.save(movie);
    }

    public void delete(final Long id) {
        movieRepository.deleteById(id);
    }

    private MovieDTO mapToDTO(final Movie movie, final MovieDTO movieDTO) {
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setVoteAverage(movie.getVoteAverage());
        movieDTO.setHasVideoFormat(movie.getHasVideoFormat());
        return movieDTO;
    }

    private Movie mapToEntity(final MovieDTO movieDTO, final Movie movie) {
        movie.setTitle(movieDTO.getTitle());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setVoteAverage(movieDTO.getVoteAverage());
        movie.setHasVideoFormat(movieDTO.getHasVideoFormat());
        return movie;
    }

    public boolean titleExists(final String title) {
        return movieRepository.existsByTitleIgnoreCase(title);
    }

}
