package src.main.java.com.storeproject.model;

import jakarta.persistence.*;

@Entity
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int price;
}
