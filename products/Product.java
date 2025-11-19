package products;

public abstract class Product {
    String name;
    double price;
    int stock;
    // int total; //should be a function of the cart
    double discount; //for now
    // abstract void applydiscount(); //should also 
                                    //a cart function
    // abstract void updatestock(); //c
    // abstract double calcTotal();
    
    
    abstract String getname();
    abstract double getprice();
    abstract int getstock();
};

