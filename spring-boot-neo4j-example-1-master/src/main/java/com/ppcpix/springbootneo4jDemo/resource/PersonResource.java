package com.ppcpix.springbootneo4jDemo.resource;

import com.ppcpix.springbootneo4jDemo.model.Person;
import com.ppcpix.springbootneo4jDemo.service.PersonService;
import com.ppcpix.springbootneo4jDemo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/")
public class PersonResource {

    @Autowired
    PersonService personService;


    @GetMapping("/user")
    public Collection<Person> getAll() {
        return personService.getAll();
    }
    @GetMapping("/movie/list")
    public Collection<Movie> getAllMovies() {
        return personService.getAllMovies();
    }

    @PostMapping("/movie/save")
    public void saveMovie(@RequestBody Movie m) {
          personService.update(m);
    }
    @GetMapping("/movie/{title}")
    public Collection<Movie> getMoviewithTitle(@PathVariable("title") @Valid @NotNull String title){
        return personService.getByTitle(title);
    }

}
