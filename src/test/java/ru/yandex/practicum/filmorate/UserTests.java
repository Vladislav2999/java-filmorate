package ru.yandex.practicum.filmorate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTests {

    @Autowired
    private UserController userController;

    @Test
    void createUserOrdinaryEmailTest() {
        User testUser = new User(1,"aaa@mail.ru","vladDDD","vlad",
                LocalDate.of(1999,01,30));
        userController.createUser(testUser);
        assertTrue(userController.getUsers().contains(testUser));
        assertEquals(testUser,userController.getUsers().get(userController.getUsers().size()-1));
    }

    @Test
    void createUserWithBlankEmailTest() {
        User testUser = new User(1,"","vladDDD","vlad",
                LocalDate.of(1999,03,29));
        ValidationException exception = assertThrows(ValidationException.class,
                () -> userController.createUser(testUser));
        assertEquals(exception.getMessage(),
                "Электронная почта не может быть пустой и должна содержать символ @ .");
    }

    @Test
    void createUserWithEmailWithoutSymbolTest() {
        User testUser = new User(1,"invalid.email.ru","vladDDD","vlad",
                LocalDate.of(1999,03,29));
        ValidationException exception = assertThrows(ValidationException.class,
                () -> userController.createUser(testUser));
        assertEquals(exception.getMessage(),
                "Электронная почта не может быть пустой и должна содержать символ @ .");
    }

    @Test
    void createUserWithBlankLoginTest() {
        User testUser = new User(1,"valid@email.ru","","vlad",
                LocalDate.of(1999,03,29));
        ValidationException exception = assertThrows(ValidationException.class,
                () -> userController.createUser(testUser));
        assertEquals(exception.getMessage(),"Логин не может быть пустым и содержать пробелы.");
    }

    @Test
    void createUserWithLoginWithBlanksTest() {
        User testUser = new User(1,"valid@email.ru","v v v","vlad",
                LocalDate.of(1999,03,29));
        ValidationException exception = assertThrows(ValidationException.class,
                () -> userController.createUser(testUser));
        assertEquals(exception.getMessage(),"Логин не может быть пустым и содержать пробелы.");
    }

    @Test
    void createUserWithBlankNameTest() {
        User testUser = new User(1,"valid@email.ru","aaaa","",
                LocalDate.of(1999,03,29));
        userController.createUser(testUser);
        assertTrue(userController.getUsers().contains(testUser));
        assertEquals(testUser,userController.getUsers().get(0));
        assertEquals(testUser.getName(),userController.getUsers().get(0).getLogin());
    }

    @Test
    void createUserWithDateOfBirthInFutureTest() {
        User testUser = new User(1,"valid@email.ru","vladDDD","vlad",
                LocalDate.of(2024,03,29));
        ValidationException exception = assertThrows(ValidationException.class,
                () -> userController.createUser(testUser));
        assertEquals(exception.getMessage(),"Дата рождения не может быть в будущем.");
    }
}