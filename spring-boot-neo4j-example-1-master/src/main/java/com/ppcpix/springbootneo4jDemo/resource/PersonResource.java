package com.ppcpix.springbootneo4jDemo.resource;

import com.ppcpix.springbootneo4jDemo.model.Person;
import com.ppcpix.springbootneo4jDemo.service.PersonService;
import com.ppcpix.springbootneo4jDemo.model.Movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/")
@Api(value = "Person Node", description = "Person Node - Neo4j Demo Application")
public class PersonResource {

    @Autowired
    PersonService personService;


    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Person Node")
    public Collection<Person> getAll() {
        return personService.getAll();
    }
    @GetMapping("/movie/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Movies Node")
    public Collection<Movie> getAllMovies() {
        return personService.getAllMovies();
    }

    @PostMapping("/movie/save")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create new Movie Node")
    public void saveMovie(@RequestBody Movie m) {
          personService.update(m);
    }
    @GetMapping("/movie/{title}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "get movie Node with specific Title")
    public Collection<Movie> getMoviewithTitle(@PathVariable("title") @Valid @NotNull String title){
        return personService.getByTitle(title);
    }

}
