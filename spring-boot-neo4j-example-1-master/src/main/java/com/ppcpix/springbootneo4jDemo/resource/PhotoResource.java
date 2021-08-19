package com.ppcpix.springbootneo4jDemo.resource;

import com.ppcpix.springbootneo4jDemo.model.Movie;
import com.ppcpix.springbootneo4jDemo.model.Photo;
import com.ppcpix.springbootneo4jDemo.service.PhotoService;
import com.ppcpix.springbootneo4jDemo.service.QueryNeo4jService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/")
@Api(value = "Photo Node", description = "Photo Node - Neo4j Demo Application")
public class PhotoResource {

    @Autowired
    PhotoService photoService;
    @Autowired
    QueryNeo4jService queryNeo4JService;


    @PostMapping ("/photo/create")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create new Photo Node")
    public Photo createPhotoRecord(@RequestBody Photo photo) {
        return photoService.createNewRecord(photo);
    }

    @GetMapping("/photo/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Photo Nodes")
    public Collection<Photo> getPhoto() {
        return  photoService.getPhotos();
    }
    @DeleteMapping("/photo/delete")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a photo Node")
    public void delete() {
        photoService.deleteNode();
    }

    @DeleteMapping("/photo/deleteAll")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete All Photo Nodes")
    public void deleteAll() {
        photoService.deleteNodeNew();
    }

    @PostMapping("/photo/save")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Save a Photo Details")
    public void save(@RequestBody Photo photo){
        photoService.saveNode(photo);
    }

    @GetMapping("/execute")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Execute Custom Query")
    public void execute(Movie movie){
        queryNeo4JService.executeQuery(Movie.class,movie);
    }
}
