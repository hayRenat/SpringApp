package ru.gb.SpringApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.SpringApp.exceptions.ResourceNotFoundException;
import ru.gb.SpringApp.model.Product;
import ru.gb.SpringApp.repositories.ProductRepo;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product findById(Long id){
        return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Продукта с ID - " + id + ", не существует"));
    }

    public int getProductCount(){
        return productRepo.getProductList().size();
    }

    public float getAveragePrice(){
        if (getProductCount() == 0){
            return 0;
        }
        int avg = 0;
        for (Product product: productRepo.getProductList()){
            avg += product.getCost();
        }
        return avg /= getProductCount();
    }

    public List<Product> getProductList(){
        return productRepo.getProductList();
    }

}
