package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface ProductManager {
    Map<Integer,Product> getListProduct();
    void addProduct(String id,String name,String date,String number,String price) throws Exception;
    void updateProduct(String id,String name,String date,String number,String price) throws Exception;
    void deleteProduct(String id);
    Product findProductById(String id);
    Product findProductByName(String name);
}
