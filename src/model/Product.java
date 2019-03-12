package model;


public class Product {
    private int id;
    private String name;
    private double price;
    private int number;
    private String date;
    public  Product(int id,String name,double price,int number,String date){
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.date = date;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
