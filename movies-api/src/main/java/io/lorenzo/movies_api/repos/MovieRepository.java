package io.lorenzo.movies_api.repos;

import io.lorenzo.movies_api.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    boolean existsByTitleIgnoreCase(String title);

}
