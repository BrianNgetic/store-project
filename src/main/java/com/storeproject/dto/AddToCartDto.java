package com.storeproject.dto;

import com.storeproject.model.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartDto {
    
    public Long  Id;
    public int Quantity;


public Long getId(){
    return this.Id;
}

public  int getQuantity(){
    return this.Quantity;
}
public void setQuantity(int  quantity){
    this.Quantity = quantity;
}
}
