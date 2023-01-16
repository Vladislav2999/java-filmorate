package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Genre extends StorageData {
    @NotBlank(message = "имя жанра не может быть пустым")
    @NotEmpty(message = "имя жанра не может быть равным нулю или null")
    private String name;

    public Genre(Long id, String name) {
        super(id);
        this.name = name;
    }
}
