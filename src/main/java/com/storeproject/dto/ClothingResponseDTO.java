package com.storeproject.dto;


import java.time.LocalDate;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ClothingResponseDTO extends CreatedProduct{
  
    private String clothSize;
    private String clothColor;
}
