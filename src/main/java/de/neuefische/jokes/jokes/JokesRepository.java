package de.neuefische.jokes.jokes;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Document
public interface JokesRepository extends MongoRepository <Jokes, String > {
    List<Jokes> findByKlass(String klass);
    }
