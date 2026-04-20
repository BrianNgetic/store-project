package com.storeproject.dto;


import java.time.LocalDate;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicResponseDTO extends CreatedProduct{
       
   
    private Boolean warrantyEligible;
    private Integer warrantyPeriod;
    private Double productVersion;
    private Integer updatedProductVersion;

}