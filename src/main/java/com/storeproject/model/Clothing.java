
package com.storeproject.model;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "clothing")
public class Clothing  extends  Product{
    

    @Column(name = "prod_type")
    private String type;



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

    // @Override
    // String getname() {
    //     // TODO
    //     return name;
    // }

    // @Override
    // double getprice() {
    //     // TODO
    //     return price;
    // // }

    // / @Override
    // int getstock() {
    //     // TODO
    //     return stock;
    // }


    @Override
    public void validate() {
        
    }
}
