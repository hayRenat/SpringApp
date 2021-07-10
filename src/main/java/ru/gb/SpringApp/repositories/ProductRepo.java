package ru.gb.SpringApp.repositories;

import org.springframework.stereotype.Component;
import ru.gb.SpringApp.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepo {

    private List<Product> productList;

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProduct(int index) {
        return productList.get(index);
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void updateProduct(Product product){
        int index = productList.indexOf(product);
        productList.set(index, product);
    }

    public void deleteProduct(Product product){
        productList.remove(product);
    }

    public Optional<Product> findById(long id){
        return productList.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1L, "Apple", 25.9f));
        productList.add(new Product(2L, "Orange", 36.9f));
        productList.add(new Product(3L, "Banana", 45.5f));
        productList.add(new Product(4L, "Peach", 38.7f));
        productList.add(new Product(5L, "Cupcake", 20.0f));
        productList.add(new Product(6L, "Donut", 12.6f));
    }
}
