
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
    

    @Column(name = "prod_type")
    private string type;


    @Column(name = "prod_stock")
    private int stock;

    @Column(name = "size")
    private String size;
    
    @Column (name = "color")
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
