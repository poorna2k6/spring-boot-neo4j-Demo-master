package com.ppcpix.springbootneo4jDemo.repository;

import com.ppcpix.springbootneo4jDemo.model.Photo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PhotoRepository extends Neo4jRepository<Photo, Long> {

    //@Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    @Query("CREATE (c:Photo {size:'898MB', location: 'Frisco Texas',time: '18th Aug 2021'})")
    Photo create(String nodeName,String size);
    @Query("MATCH (c:Photo) DETACH DELETE c")
    Photo deletePhoto();
    @Query("MATCH (c:Photo) RETURN c")
    Collection<Photo> getPhotoList();
}
