package de.neuefische.jokes.jokes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class JokesService {
    private final JokesRepository jokesRepository;

    public Jokes createNewJokes(Jokes jokes){
    return jokesRepository.save(jokes);
    }

    public Optional<Jokes> findByID(String id) {
        return jokesRepository.findById(id);
    }

    public List<Jokes> findByKlass(String klass){
        return jokesRepository.findByKlass(klass);
    }


}
