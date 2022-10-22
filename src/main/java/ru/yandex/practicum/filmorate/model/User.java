package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class User {
    private Integer id;
    @NotNull
    private String name;
    @NotBlank
    @Email
    private  String email;
    @NotBlank
    private  String login;
    @PastOrPresent
    private final LocalDate birthday;

    public User(LocalDate birthday) {
        this.birthday = birthday;
    }
}
