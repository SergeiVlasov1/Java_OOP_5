package ru.netology.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book product1 = new Book(1, "Дневник охотника за ошибками. Путешествие через джунгли проблем безопасности программного обеспечения", 300, "Тобиас Клейн");
    private Book product2 = new Book(2, "Тестирование программного обеспечения. Базовый курс", 550, "Святослав Куликов");
    private Book product3 = new Book(3, "Джоэл о программировании", 690, "Джоэл Спольски");
    private Book product4 = new Book(4, "Не заставляйте меня думать", 815, "Стив Круг");
    private Book product5 = new Book(5, "Джоэл. И снова о программировании", 950, "Джоэл Спольски");
    private Smartphone product6 = new Smartphone(6, "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, зеленый", 26000, "Xiaomi");
    private Smartphone product7 = new Smartphone(7, "Xiaomi 12X 8/128 ГБ RU, фиолетовый", 46000, "Xiaomi");
    private Smartphone product8 = new Smartphone(8, "Samsung Galaxy A53 5G 6/128 ГБ, белый", 39000, "Samsung");
    private Smartphone product9 = new Smartphone(9, "Xiaomi Redmi 9T NFC 4/64 ГБ RU, синие сумерки", 17000, "Xiaomi");
    private Smartphone product10 = new Smartphone(10, "Apple iPhone 12 64 ГБ, фиолетовый", 55000, "Apple");

    
    @Test
    public void shouldSearchBookByNameIfExists() {
        String name = "Тестирование программного обеспечения. Базовый курс";
        assertTrue(product2.matches(name));
    }

    @Test
    public void shouldNotSearchBookByNameIfNotExists() {
        String name = "Тестирование Дот Ком, или Пособие по жестокому обращению с багами в интернет-стартапах";
        assertFalse(product2.matches(name));
    }

    @Test
    public void shouldSearchBookByAuthorIfExists() {
        String author = "Стив Круг";
        assertTrue(product4.matches(author));
    }

    @Test
    public void shouldNotSearchBookByAuthorIfNotExists() {
        String author = "Джеральд М. Вайнберг";
        assertFalse(product4.matches(author));
    }

    @Test
    public void shouldSearchSmartphoneByNameIfExists() {
        String name = "Apple iPhone 12 64 ГБ, фиолетовый";
        assertTrue(product10.matches(name));
    }

    @Test
    public void shouldNotSearchSmartphoneByNameIfNotExists() {
        String name = "Apple iPhone 12 64 ГБ, белый";
        assertFalse(product10.matches(name));
    }

    @Test
    public void shouldSearchSmartphoneByManufacturerIfExists() {
        String manufacturer = "Apple";
        assertTrue(product10.matches(manufacturer));
    }

    @Test
    public void shouldNotSearchSmartphoneByManufacturerIfNotExists() {
        String manufacturer = "Honor";
        assertFalse(product10.matches(manufacturer));
    }

}