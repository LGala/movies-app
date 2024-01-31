package io.lorenzo.movies_api.controller;

import io.lorenzo.movies_api.model.MovieDTO;
import io.lorenzo.movies_api.service.MovieServiceV1;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/movies/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieControllerV1 {
    final static Logger logger = LogManager.getRootLogger();

    @Autowired
    private MovieServiceV1 movieServiceV1;

    @GetMapping
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "404")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        try {
            return ResponseEntity.ok(movieServiceV1.findAll());
        } catch (Exception e) {
            logger.error("Movies not found");
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Long> createMovie(@RequestBody @Valid final MovieDTO movieDTO) {
        try {
            movieServiceV1.create(movieDTO);
            logger.info("Movie created with id {}", movieDTO.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error while creating movie");
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Long> updateMovie(@PathVariable(name = "id") final Long id, @RequestBody @Valid final MovieDTO movieDTO) {
        try {
            movieServiceV1.update(id, movieDTO);
            logger.info("Movie updated with id {}", id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            logger.error("Error while updating movie");
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    @ApiResponse(responseCode = "500")
    public ResponseEntity<Void> deleteMovie(@PathVariable(name = "id") final Long id) {
        try {
            movieServiceV1.delete(id);
            logger.info("Movie deleted with id {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error while deleting movie");
            return ResponseEntity.internalServerError().build();
        }
    }
}
