package com.ppcpix.springbootneo4jDemo.service;


import org.neo4j.driver.*;
import org.neo4j.driver.async.AsyncSession;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class QueryNeo4jService <T>{
    public Collection<T> executeQuery(Class<T> type , Object m){
        String uri;
        AuthToken auth;
        Config config = Config.builder().build();
        uri = "bolt://localhost:7687";
        auth = AuthTokens.basic("neo4j", "password");

        try (Driver driver = GraphDatabase.driver(uri, auth, config)) {
            try (Session session = driver.session()) {
                session.run("MATCH (m:Movie) RETURN m.title AS title")
                        .list(r -> r.get("title").asString())
                        .forEach(System.out::println);
            }

            AsyncSession session = driver.asyncSession();

            List<String> movieTitles = session.runAsync("MATCH (m:Movie) RETURN m.title AS title")
                    .thenCompose(cursor -> cursor.listAsync(record -> record.get("title").asString()))
                    .thenCompose(titles -> session.closeAsync()
                            .thenApply(ignore -> titles))
                    .toCompletableFuture()
                    .get();

            System.out.println("Fetched " + movieTitles.size() + " async (and blocked doing so)");
        }catch(Exception ex){

        }
        return null;
    }
}
