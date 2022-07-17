package com.example.demo.service;

import com.example.demo.domain.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"lastResult"})
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Cacheable
    public List<Movie> search(String name) {
        doSomething(name);
        return movieRepository.findByGenresContaining(name);
    }


    // Mock latency
    private void doSomething(String name) {
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
        movieRepository.findByGenresContaining(name);
    }
}
