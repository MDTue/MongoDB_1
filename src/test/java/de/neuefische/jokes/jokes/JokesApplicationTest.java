package de.neuefische.jokes.jokes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JokesApplicationTest {
@Autowired
private TestRestTemplate restTemplate;

    @Test
    void contextLoads(){
        Jokes jokes = new Jokes();
        jokes.setJoke("Kürzester Witz?");
        jokes.setRightAnswer("schon vorbei!");
        jokes.setKlass("ok");
        ResponseEntity<Jokes> postResponse = restTemplate.postForEntity("/jokes", jokes, Jokes.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getId()).isNotNull();
        assertThat(postResponse.getBody().getJoke()).isEqualTo("Kürzester Witz?");
        assertThat(postResponse.getBody().getRightAnswer()).isEqualTo("schon vorbei!");
        assertThat(postResponse.getBody().getKlass()).isEqualTo("ok");

        ResponseEntity<Jokes> getResponse = restTemplate.getForEntity("/jokes/" + postResponse.getBody().getId(), Jokes.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody().getId()).isNotNull();
        assertThat(getResponse.getBody().getJoke()).isEqualTo("Kürzester Witz?");
        assertThat(getResponse.getBody().getRightAnswer()).isEqualTo("schon vorbei!");
        assertThat(getResponse.getBody().getKlass()).isEqualTo("ok");
    }
}
