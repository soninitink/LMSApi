package com.tcs.edureka.lmsapi.services;

import com.tcs.edureka.lmsapi.models.Genre;
import com.tcs.edureka.lmsapi.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService {
    private GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(int id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre addGenre(Genre Genre) {
        return genreRepository.save(Genre);
    }

    public Genre updateGenre(int id, Genre updatedGenre) {
        Genre existingGenre = genreRepository.findById(id).orElse(null);

        if (existingGenre != null) {
            existingGenre.setGenre(updatedGenre.getGenre());
            return genreRepository.save(existingGenre);
        }
        return null;
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
