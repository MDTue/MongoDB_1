package de.neuefische.jokes.jokes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Jokes {
    @Id
    private String id;
    private String joke;
    private String klass;
    private String rightAnswer;
}
