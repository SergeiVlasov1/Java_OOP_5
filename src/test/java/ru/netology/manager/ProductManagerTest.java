package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Дневник охотника за ошибками. Путешествие через джунгли проблем безопасности программного обеспечения", 300, "Тобиас Клейн");
    private Book secondBook = new Book(2, "Тестирование программного обеспечения. Базовый курс", 550, "Святослав Куликов");
    private Book thirdBook = new Book(3, "Джоэл о программировании", 690, "Джоэл Спольски");
    private Book fourthBook = new Book(4, "Не заставляйте меня думать", 815, "Стив Круг");
    private Book fifthBook = new Book(5, "Джоэл. И снова о программировании", 950, "Джоэл Спольски");
    private Smartphone firstSmartphone = new Smartphone(6, "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, зеленый", 26000, "Xiaomi");
    private Smartphone secondSmartphone = new Smartphone(7, "Xiaomi 12X 8/128 ГБ RU, фиолетовый", 46000, "Xiaomi");
    private Smartphone thirdSmartphone = new Smartphone(8, "Samsung Galaxy A53 5G 6/128 ГБ, белый", 39000, "Samsung");
    private Smartphone fourthSmartphone = new Smartphone(9, "Xiaomi Redmi 9T NFC 4/64 ГБ RU, синие сумерки", 17000, "Xiaomi");
    private Smartphone fifthSmartphone = new Smartphone(10, "Apple iPhone 12 64 ГБ, фиолетовый", 55000, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
        manager.add(fifthSmartphone);
    }

    @Test
    public void shouldSearchBookByNameIfExists() {
        String name = "Тестирование программного обеспечения. Базовый курс";
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByNameIfNotExists() {
        String name = "Тестирование Дот Ком, или Пособие по жестокому обращению с багами в интернет-стартапах";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthorIfExists() {
        String author = "Стив Круг";
        Product[] expected = new Product[]{fourthBook};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchBookByAuthorIfNotExists() {
        String author = "Джеральд М. Вайнберг";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByNameIfExists() {
        String name = "Apple iPhone 12 64 ГБ, фиолетовый";
        Product[] expected = new Product[]{fifthSmartphone};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneByNameIfNotExists() {
        String name = "Apple iPhone 12 64 ГБ, белый";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturerIfExists() {
        String manufacturer = "Apple";
        Product[] expected = new Product[]{fifthSmartphone};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchSmartphoneByManufacturerIfNotExists() {
        String manufacturer = "Honor";
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductsWithSameAuthor() {
        String author = "Джоэл Спольски";
        Product[] expected = new Product[]{thirdBook, fifthBook};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchProductsWithSameManufacturer() {
        String manufacturer = "Xiaomi";
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone, fourthSmartphone};
        Product[] actual = manager.searchBy(manufacturer);
        assertArrayEquals(expected, actual);
    }
}