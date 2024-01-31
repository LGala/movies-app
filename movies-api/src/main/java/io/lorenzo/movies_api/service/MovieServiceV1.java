package io.lorenzo.movies_api.service;

import io.lorenzo.movies_api.entity.MovieEntity;
import io.lorenzo.movies_api.model.MovieDTO;
import io.lorenzo.movies_api.repos.MovieRepository;
import io.lorenzo.movies_api.util.NotFoundException;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class MovieServiceV1 {
    final static Logger logger = LogManager.getRootLogger();

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> findAll() {
        final List<MovieEntity> movieEntities = movieRepository.findAll(Sort.by("id"));

        logger.info("Movies found: {}", movieEntities.size());

        return movieEntities.stream()
                .map(movieEntity -> new MovieDTO(
                        movieEntity.getId(),
                        movieEntity.getTitle(),
                        movieEntity.getReleaseDate(),
                        movieEntity.getVoteAverage(),
                        movieEntity.getHasVideoFormat()
                ))
                .toList();
    }

    public void create(final MovieDTO movieDTO) {
        final MovieEntity movieEntity = new MovieEntity();
        movieRepository.save(mapDTOToEntity(movieDTO, movieEntity));
        logger.info("Movie created with id {}", movieDTO.getId());
    }

    public void update(final Long id, final MovieDTO movieDTO) {
        final MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        movieRepository.save(mapDTOToEntity(movieDTO, movieEntity));
        logger.info("Movie updated with id {}", id);
    }

    public void delete(final Long id) {
        movieRepository.deleteById(id);
        logger.info("Movie deleted with id {}", id);
    }

    private MovieEntity mapDTOToEntity(final MovieDTO movieDTO, final MovieEntity movieEntity) {
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setReleaseDate(movieDTO.getReleaseDate());
        movieEntity.setVoteAverage(movieDTO.getVoteAverage());
        movieEntity.setHasVideoFormat(movieDTO.getHasVideoFormat());
        return movieEntity;
    }
}
