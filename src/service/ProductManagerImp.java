package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ProductManagerImp {
    Map<Integer,Product> getListProduct();
    void addProduct(Product product);
    void updateProduct(Product product,String id);
    void deleteProduct(String id);
    Product findProductById(String id);
    Product findProductByName(String name);
}
