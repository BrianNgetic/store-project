
package com.storeproject.model;


import jakarta.persistence.*;
import lombok.*;




@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "clothing")
@PrimaryKeyJoinColumn(name = "prodId")
public class Clothing  extends  Product{
    

  



    @Column(name = "ProdSize")
    private String size;
    
    @Column (name = "ProdColor")
    private String color;
   

    

    public Clothing(
        String name,
        String category, 
        String type, 
        double price, 
        int stock, 
        String size,
        String color){

            this.name = name;
            this.category =  category;
            this.type = type;
            this.price = price;
            this.stock  = stock;
            this.size = size;
            this.color = color;
    }

    @Override
    public void validate() {
        
    }
}
