
package com.storeproject.model;


import jakarta.persistence.*;
import lombok.*;




@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "clothing")
public class Clothing  extends  Product{
    

    @Column(name = "prod_type")
    private String type;



    @Column(name = "size")
    private String size;
    
    @Column (name = "color")
    private String color;
  


    @Override
    public void validate() {
        
    }
}
