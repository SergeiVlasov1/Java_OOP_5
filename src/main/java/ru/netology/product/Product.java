package ru.netology.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        if (name.contains(search)) {
            return true;
        }
        return false;
    }
}
