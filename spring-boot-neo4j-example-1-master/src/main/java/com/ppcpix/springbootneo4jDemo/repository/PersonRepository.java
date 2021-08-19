package com.ppcpix.springbootneo4jDemo.repository;

import com.ppcpix.springbootneo4jDemo.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    //@Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
    @Query("MATCH (n:Movie) RETURN n LIMIT 25")
    Collection<Person> getAllUsers();
}
