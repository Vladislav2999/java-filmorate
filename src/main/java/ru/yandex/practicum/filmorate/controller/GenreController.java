package ru.yandex.practicum.filmorate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.model.service.GenreService;

import java.util.List;
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService service;

    @GetMapping
    public List<Genre> getAll() {
        final List<Genre> genres = service.getAll();
        log.info("Получен запрос списка жанров {}", genres.size());
        return genres;
    }

    @GetMapping("/{id}")
    public Genre get(@PathVariable long id) {
        log.info("Получен запрос жанра по id: {}", id);
        return service.get(id);
    }

}
