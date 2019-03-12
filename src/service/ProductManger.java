package service;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductManger implements ProductManagerImp {
    static Map<Integer,Product> products = new HashMap<>();
    static {
        //Map<Integer,Product> products = new HashMap<>();???
        products.put(3007,new Product(3007,"Pen",4.2,5,"10/3/2019"));
        products.put(3400,new Product(3400,"Table",14.2,10,"10/3/2019"));
        products.put(2705,new Product(2705,"Chair",25.2,6,"10/3/2019"));
        products.put(7400,new Product(7400,"Book",8,9,"10/3/2019"));
        products.put(2110,new Product(2110,"Eraser",2,5,"10/3/2019"));
    }

    @Override
    public Map<Integer,Product> getListProduct() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void updateProduct(Product product,String id) {
        Product product1 = products.get(Integer.parseInt(id));
        product1 = product;

    }

    @Override
    public void deleteProduct(String id) {
        products.remove(Integer.parseInt(id));
    }

    @Override
    public Product findProductById(String id) {
        return products.get(Integer.parseInt(id));
    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }
}
