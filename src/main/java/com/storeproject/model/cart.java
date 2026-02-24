package com.storeproject.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import jakarta.validation.constraints.*;
import com.storeproject.dto.*;
import java.io.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    protected Long id;


    @OneToOne // one user can only have one cart
    @JoinColumn(name = "user_id")
    protected Users user;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> userCartItems = new ArrayList<>();

    public void addToUserCart(CartItem cartItem){
        if(cartItem != null){
            this.userCartItems.add(cartItem);
        }
    }

    public void deleteFromUserCart(CartItem cartItem){
        if(userCartItems.contains(cartItem)){
            userCartItems.remove(cartItem);
        }
    }

    public List<CartItem> viewCart(){
        
        return userCartItems;
    }

    public double  getTotal(){
       double total = userCartItems.stream()
                .mapToDouble(item ->
                      item.getQuantity() * item.getProduct().getPrice()
                )
                .sum();


    return total;
    }





    }
    





    