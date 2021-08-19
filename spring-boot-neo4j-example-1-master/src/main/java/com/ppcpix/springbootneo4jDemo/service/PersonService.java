package com.ppcpix.springbootneo4jDemo.service;

import com.ppcpix.springbootneo4jDemo.model.Person;
import com.ppcpix.springbootneo4jDemo.repository.MovieRepository;
import com.ppcpix.springbootneo4jDemo.model.Movie;
import com.ppcpix.springbootneo4jDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    MovieRepository movieRepository;


    public Collection<Person> getAll() {
        return personRepository.getAllUsers();
    }
    public Collection<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
    public void save(Movie m){
         movieRepository.save(m);
    }
@Transactional
    public void update(Movie updateRequest) {
        movieRepository.update();
//        Collection<Movie> movie = movieRepository.findByTitle(updateRequest.getTitle());
//        List<Movie> updatedMovies=new ArrayList<>();
//        if (movie == null) return; //or throw...
//        for(Movie movie1:movie){
//            movie1.setReleased(updateRequest.getReleased());
//            updatedMovies.add(movie1);
//
//        }
//        movieRepository.save(updatedMovies);

    }
    public Collection<Movie> getByTitle(String title){
        return movieRepository.findByTitleContaining(title);
    }
}
