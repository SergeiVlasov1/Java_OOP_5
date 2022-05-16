package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book firstBook = new Book(1, "Дневник охотника за ошибками. Путешествие через джунгли проблем безопасности программного обеспечения", 300, "Тобиас Клейн");
    private Book secondBook = new Book(2, "Тестирование программного обеспечения. Базовый курс", 550, "Святослав Куликов");
    private Book thirdBook = new Book(3, "Джоэл о программировании", 690, "Джоэл Спольски");
    private Book fourthBook = new Book(4, "Не заставляйте меня думать", 815, "Стив Круг");
    private Book fifthBook = new Book(5, "Джоэл. И снова о программировании", 950, "Джоэл Спольски");

    @Test
    public void shouldMatchByNameIfExists() {
        String name = "Тобиас Клейн";
        assertTrue(firstBook.matches(name));
    }

    @Test
    public void shouldMatchByNameIfNotExists() {
        String name = "Тестирование Дот Ком, или Пособие по жестокому обращению с багами в интернет-стартапах";
        assertFalse(secondBook.matches(name));
    }

    @Test
    public void shouldMatchByAuthorIfExists() {
        String author = "Джоэл Спольски";
        assertTrue(thirdBook.matches(author));
    }

    @Test
    public void shouldMatchByAuthorIfNotExists() {
        String author = "Джеральд М. Вайнберг";
        assertFalse(fourthBook.matches(author));
    }
}