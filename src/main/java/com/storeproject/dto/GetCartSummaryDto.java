package com.storeproject.dto;

import com.storeproject.model.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class GetCartSummaryDto {

   private Product product;
    private int quantity;

    
}
