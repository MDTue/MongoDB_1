package de.neuefische.jokes.jokes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jokes")

@RequiredArgsConstructor

public class JokeController {
    private final JokesService jokesService;

    @PostMapping
    public Jokes createNewJokes(@RequestBody Jokes jokes) {
        return jokesService.createNewJokes(jokes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jokes> findJokesByID(@PathVariable String id) {
        return ResponseEntity.of(jokesService.findByID(id));
    }
    @GetMapping
    public List<Jokes> findJokesByKlass(@RequestParam String klass) {
        return jokesService.findByKlass(klass);
    }


}