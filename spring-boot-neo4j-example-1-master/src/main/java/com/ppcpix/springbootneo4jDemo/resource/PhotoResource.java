package com.ppcpix.springbootneo4jDemo.resource;

import com.ppcpix.springbootneo4jDemo.model.Photo;
import com.ppcpix.springbootneo4jDemo.service.PhotoService;
import com.ppcpix.springbootneo4jDemo.service.QueryNeo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/")
public class PhotoResource {

    @Autowired
    PhotoService photoService;
    @Autowired
    QueryNeo4jService queryNeo4JService;


    @PostMapping ("/photo/create")
    public Photo createPhotoRecord(@RequestBody Photo photo) {
        System.out.println("Time in createNewRecordController Start:"+new Timestamp(System.currentTimeMillis()));
        Photo photo1= photoService.createNewRecord(photo);
        System.out.println("Time in createNewRecordController Start:"+new Timestamp(System.currentTimeMillis()));
        return photo1;
    }

    @GetMapping("/photo/list")
    public Collection<Photo> getPhoto() {
        System.out.println("Time in createNewRecordController Start:"+new Timestamp(System.currentTimeMillis()));
        Collection<Photo> photo= photoService.getPhotos();
        System.out.println("Time in createNewRecordController Start:"+new Timestamp(System.currentTimeMillis()));
        return photo;
    }
    @DeleteMapping("/photo/delete")
    public void delete() {
        System.out.println("Time in Delete Controller Start:"+new Timestamp(System.currentTimeMillis()));
         photoService.deleteNode();
        System.out.println("Time in Delete Controller End:"+new Timestamp(System.currentTimeMillis()));
    }

    @DeleteMapping("/photo/deleteAll")
    public void deleteAll() {
        System.out.println("Time in DeleteALL Controller Start:"+new Timestamp(System.currentTimeMillis()));
        photoService.deleteNodeNew();
        System.out.println("Time in DeleteALL Controller End:"+new Timestamp(System.currentTimeMillis()));
    }
//    @GetMapping("/execute")
//    public void testExecute(){
//        System.out.println("Time in testExecute Controller Start:"+new Timestamp(System.currentTimeMillis()));
//        queryNeo4JService.printGreeting();
//        System.out.println("Time in testExecute Controller End:"+new Timestamp(System.currentTimeMillis()));
//
//    }
    @PostMapping("/photo/save")
    public void save(@RequestBody Photo photo){
        photoService.saveNode(photo);
    }

    @GetMapping("/execute")
    public void execute(){
        queryNeo4JService.executeQuery();
    }
}
