
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
   

    


    @Override
    public void validate() {
        
    }
}
