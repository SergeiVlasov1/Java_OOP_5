package ru.netology.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone firstSmartphone = new Smartphone(6, "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, зеленый", 26000, "Xiaomi");
    private Smartphone secondSmartphone = new Smartphone(7, "Xiaomi 12X 8/128 ГБ RU, фиолетовый", 46000, "Xiaomi");
    private Smartphone thirdSmartphone = new Smartphone(8, "Samsung Galaxy A53 5G 6/128 ГБ, белый", 39000, "Samsung");
    private Smartphone fourthSmartphone = new Smartphone(9, "Xiaomi Redmi 9T NFC 4/64 ГБ RU, синие сумерки", 17000, "Xiaomi");
    private Smartphone fifthSmartphone = new Smartphone(10, "Apple iPhone 12 64 ГБ, фиолетовый", 55000, "Apple");

    @Test
    public void shouldMatchByNameIfExists() {
        String name = "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, зеленый";
        assertTrue(firstSmartphone.matches(name));
    }

    @Test
    public void shouldMatchByNameIfNotExists() {
        String name = "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, белый";
        assertFalse(secondSmartphone.matches(name));
    }

    @Test
    public void shouldMatchByManufacturerIfExists() {
        String manufacturer = "Samsung";
        assertTrue(thirdSmartphone.matches(manufacturer));
    }

    @Test
    public void shouldMatchByManufacturerIfNotExists() {
        String manufacturer = "Honor";
        assertFalse(fourthSmartphone.matches(manufacturer));
    }
}