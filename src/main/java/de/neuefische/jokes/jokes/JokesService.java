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

    public List<Jokes> findById(String id) {
        return jokesRepository.findAll();
    }
    public List<Jokes> findAllJokes() {
        return jokesRepository.findAll();
    }



    public List<Jokes> findByKlass(String klass){
        return jokesRepository.findByKlass(klass);
    }

    public Jokes updateJokes(Jokes jokes){
        return jokesRepository.save(jokes);
    }

    public Optional<Jokes> patchJokes(String id, Jokes jokes) {

        Optional<Jokes> optionalJokes = jokesRepository.findById(id);
        if (optionalJokes.isPresent()) {
            Jokes jokesFromDatabase = optionalJokes.get();
            if (jokes.getJoke() != null) {
                jokesFromDatabase.setJoke(jokes.getJoke());
            }
            if (jokes.getKlass() != null) {
                jokesFromDatabase.setKlass(jokes.getKlass());
            }
            return Optional.of(jokesRepository.save(jokesFromDatabase));
        } else {
            return Optional.empty();
        }

    }
    /*    return jokesRepository.findById(id)
                .map(j -> j.patch(jokes))
                .map(jokesRepository::save);
    }*/

}
