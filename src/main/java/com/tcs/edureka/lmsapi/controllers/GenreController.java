package com.tcs.edureka.lmsapi.controllers;

import com.tcs.edureka.lmsapi.models.Genre;
import com.tcs.edureka.lmsapi.repository.GenreRepository;
import com.tcs.edureka.lmsapi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }
    @GetMapping
    public List<Genre> getAllGenres(){
        return genreService.getAllGenres();
    }
    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable int id){
        return genreService.getGenreById(id);
    }
    @PostMapping
    public Genre addGenre(@RequestBody Genre genre){
        return  genreService.addGenre(genre);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable int id, @RequestBody Genre genre){
        return genreService.updateGenre(id, genre);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        genreService.deleteGenre(id);
    }
}
