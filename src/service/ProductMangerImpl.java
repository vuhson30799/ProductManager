package service;

import model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductMangerImpl implements ProductManager {
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
    public void addProduct(String id, String name, String date, String number, String price) throws Exception {
        checkConvertString(id,name,date,number,price);
        Product product = new Product(Integer.parseInt(id),name,Double.parseDouble(price),Integer.parseInt(number),date);
        products.put(product.getId(),product);
    }

    @Override
    public void updateProduct(String id,String name,String date,String number,String price) throws Exception {
        Product product = this.findProductById(id);
        checkConvertString(id,name,date,number,price);
        product.setName(name);
        product.setPrice(Double.parseDouble(price));
        product.setNumber(Integer.parseInt(number));
        product.setDate(date);

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

    private void checkConvertString(String id,String name,String date,String number,String price) throws Exception{
        try{
            Double.parseDouble(price);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Price is invalid");
        }
        try{
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Number is invalid");
        }

        String REGEX_DATE ="^[\\d]{1,2}/[\\d]{1,2}/[\\d]{4}$";
        Pattern pattern = Pattern.compile(REGEX_DATE),
                pattern1 = Pattern.compile("/");
        Matcher matcher = pattern.matcher(date);


        if (matcher.matches()){
            String[] strings = pattern1.split(date);
            int day = Integer.parseInt(strings[0]),
                    month = Integer.parseInt(strings[1]),
                    year = Integer.parseInt(strings[2]);

            if (day > 31){
                throw new Exception("Date is invalid");
            }else if (day >29 && month == 2){
                throw new Exception("Date is invalid");
            }else if (year % 4 != 0){
                if (day > 28 && month == 2){
                    throw new Exception("Date is invalid");
                }
            }
            if (month > 12 || month < 1){
                throw new Exception("Date is invalid");
            }
            if (month == 4 || month == 6 || month == 9 || month == 11){
                if (day > 30){
                    throw new Exception("Date is invalid");
                }
            }
        }else {
            throw new Exception("Date is invalid");
        }
    }
}
