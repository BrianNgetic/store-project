package products;

public abstract class Product {
    String name;
    double price;
    int stock;
    int total;
    int discount;
    abstract void applydiscount();
    abstract void updatestock();
    abstract double calcTotal();
    
    
    abstract String getname();
    abstract double getprice();
    abstract int getstock();
};
