 package com.ppcpix.springbootneo4jDemo.service;

import com.ppcpix.springbootneo4jDemo.model.Photo;
import com.ppcpix.springbootneo4jDemo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;

@Service
@Transactional
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public Photo createNewRecord(Photo photo) {
        System.out.println("Time in createNewRecordService Start:"+new Timestamp(System.currentTimeMillis()));
        Photo photo1= photoRepository.create(photo.getNodeName(),photo.getSize());
        System.out.println("Time in createNewRecordService End:"+new Timestamp(System.currentTimeMillis()));
        return photo1;
    }
    public Collection<Photo> getPhotos(){
        return photoRepository.getPhotoList();
    }
    public void deleteNode() {

        System.out.println("Time in DeleteNode Start:"+new Timestamp(System.currentTimeMillis()));

         photoRepository.deletePhoto();
        System.out.println("Time in DeleteNode End:"+new Timestamp(System.currentTimeMillis()));
    }
    public void deleteNodeNew(){
        photoRepository.deleteAll();
    }

    public void deleteSpecificNode(Photo photo){
        photoRepository.delete(photo.getId());
    }
    public void saveNode(Photo photo){
        photoRepository.save(photo);
    }
//    public Collection<Movie> getAllMovies() {
//        return movieRepository.getAllMovies();
//    }
//    public void save(Movie m){
//         movieRepository.save(m);
//    }
//@Transactional
//    public void update(Movie updateRequest) {
//        movieRepository.update();
////        Collection<Movie> movie = movieRepository.findByTitle(updateRequest.getTitle());
////        List<Movie> updatedMovies=new ArrayList<>();
////        if (movie == null) return; //or throw...
////        for(Movie movie1:movie){
////            movie1.setReleased(updateRequest.getReleased());
////            updatedMovies.add(movie1);
////
////        }
////        movieRepository.save(updatedMovies);
//
//    }
//    void executeNew(){
//
//        GraphDatabase graphDatabase = new GraphDatabase();
//        graphDatabase.
//
//    }

}
