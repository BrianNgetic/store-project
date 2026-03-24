
package com.storeproject.model;

// import java.io.*;
// import java.lang.*;

// import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import lombok.*;


@Entity

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "electronics")
@PrimaryKeyJoinColumn(name = "prodId")
public class Electronics extends  Product{


 
    @Column(name =  "warrantyElegible")
    private boolean  warrantyElible;

    @Column(name = "warrantyPeriod")
    private int warrantyPeriod;

    @Column(name = "productVersion")
    private double productVersion;


    public Electronics(
        String name,
        String category, 
        String type, 
        double price, 
        int stock, 
        boolean warrantyElegible,
        int warrantyPeriod,
        double productVersion){

            this.name = name;
            this.category =  category;
            this.type = type;
            this.price = price;
            this.stock  = stock;
            this.warrantyElible = warrantyElegible;
            this.warrantyPeriod = warrantyPeriod;
            this.productVersion = productVersion;
    }
   

    @Transient
     private static int updatedProductVersion;
     //to come back to 

    
    
    @Transient
    void updateversion(){
        //update the product version
        productVersion = updatedProductVersion;
    }

    




    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

