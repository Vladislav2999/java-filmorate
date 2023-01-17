package ru.yandex.practicum.filmorate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.service.MpaService;


import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/mpa")
public class MpaController {

    private final MpaService service;

    @GetMapping("/{id}")
    public Mpa get(@PathVariable long id) {
        log.info("Получен запрос рейтинга MPA по id: {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Mpa> getAll() {
        log.info("Получен запрос списка MPA");
        return service.getAll();
    }

}
