package models;

public class Product {

    private int id;
    private String name;
    private String description;
    private double price;
    private int category;

    public Product(){} //default constructor

    //for POST requests
    public Product(String name, String description, double price, int category_id){
        //id(primary key) not included because it's added automatically by db logic
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);

    }

    //for PUT requests
    public Product(int id, String name, String description, double price, int category_id){
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory_id(int category) {
        this.category = category;
    }
}
