
package com.storeproject.model;

import java.io.*;
// import java.lang.*;

// import javax.annotation.processing.Generated;

import jakarta.persistence.*;
import lombok.*;


@Entity

@Getter
@Setter 
@NoArgsConstructor
@Table(name = "electronics")
public class Electronics extends  Product{


    @Column (name = "prodName" , nullable = false)
    protected  String name;

    @Column(name =  "warrantyElegible")
    private boolean  warrantyElible;

    @Column(name = "warrantyPeriod")
    private int warrantyPeriod;

    @Column(name = "productVersion")
    private double productVersion;

   

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

