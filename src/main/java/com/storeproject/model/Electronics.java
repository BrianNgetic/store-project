
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



    @Column(name =  "warranty_elegible")
    private boolean  warrantyElible;

    @Column(name = "warranty_period")
    private int warrantyPeriod;

    @Column(name = "product_version")
    private double productVersion;

    @Column(name = "prod_type")
    private String product_type;

    @Transient
     private static int updatedProductVersion;
     //to come back to 

    
    
    @Transient
    void updateversion(){
        //update the product version
        productVersion = updatedProductVersion;
    }

    @Transient
    boolean isunderWarranty(){
        return warrantyElible;// only true if it was less than 30 days ago. 
    }




    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

