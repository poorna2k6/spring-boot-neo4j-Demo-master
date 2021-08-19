package com.ppcpix.springbootneo4jDemo.repository;

import com.ppcpix.springbootneo4jDemo.model.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    //@Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    @Query("MATCH (n:Movie) RETURN n LIMIT 25")
    Collection<Movie> getAllMovies();
    @Query("MATCH (c:Movie {title: 'The Matrix Reloaded'}) SET c.released = 2050")
    @Transactional
    void update();
    //Collection<Movie> findByTitle(@Param("title") String title);
    @Query("MATCH (m:Movie) WHERE m.title = $title RETURN m")
    Collection<Movie> findByTitleContaining(@Param("title") String title);

    @Query("Create (m:$name) {released:$year,title:$movieName,tag:$tag} RETURN m")
    Collection<Movie> createNew(@Param("movieName") String movieName);


}
