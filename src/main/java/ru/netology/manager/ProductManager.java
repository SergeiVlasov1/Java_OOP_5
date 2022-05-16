package ru.netology.manager;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.product.Product;
import ru.netology.product.Book;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

@Data
@NoArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public ProductManager (ProductRepository repository) {
        this.repository = repository;
    }
    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
            return false;
        }
        return false;
    }



}
