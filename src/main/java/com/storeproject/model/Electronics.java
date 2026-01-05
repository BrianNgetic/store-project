
package src.main.java.com.storeproject.model;

import java.io.*;
// import java.lang.*;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.*;

@Entity

@Getter
@Settter 
@NoArgsConstructor
@Table(name = "electronics")
public class Electronics extends  Product{

    @ID
    @GeneratedValue(strategy= = GenerationType.AUTO)
    @column(name = "prod_id")
    private int id;

    @column
    boolean  warrantyElible;
    int warrantyPeriod;
    int batteryLevel;
    double productVersion;
    
    private static int updatedProductVersion;



    

    void updateversion(){
        //update the product version
        productVersion = updatedProductVersion;
    }
    boolean isunderWarranty(){
        return warrantyElible;// only true if it was less than 30 days ago. 
    }

    // @Override
    // void applydiscount() {
    //     // TODO
    // }

    // @Override
    // void updatestock() {
    //     // TODO
    // }

    // @Override
    // double calcTotal() {
    //     return total;
    //     // TODO
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

