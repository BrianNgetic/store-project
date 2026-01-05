
package src.main.java.com.storeproject.model;
import java.beans.ConstructorProperties;
import java.io.BufferedReader;
import java.io.FileReader;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Table(name = "clothing")
public class Clothing  extends  Product{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @column(name = "prod_id");
    @NotNull
    private int id;

    @column(name = "prod_type")
    private string type;

    @column(name = "prod_price")
    private double price;

    @column(name = "prod_stock")
    private int stock;

    @column(name = "size")
    private String size;
    
    @column (name = "color")
    private String color;
  


    

    // @Override
    // void applydiscount() {v ////this is business logic to be handled with our 
    //     // TODO
    // }

    // @Override
    // void updatestock() {
    //     // TODO
    // }

  //  @Override
    // double calcTotal() {
    //     // TODO
    //     return total;
    // }

    @Override
    String getname() {
        // TODO
        return name;
    }

    @Override
    double getprice() {
        // TODO
        return price;
    }

    @Override
    int getstock() {
        // TODO
        return stock;
    }
}
