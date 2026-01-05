package src.main.java.com.storeproject.model;


import jakarta.persistence.*;

@Entity
@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = prod_id)
    protected  Long id;
    
  
    @Column (name = "prod_name")
    protected  String name;

    @Column (name = "prod_price")
    protected double  price;

    @Column (name = "prod_stock")
    protected int stock;

    public abstract  boolean isInStock();

    public abstract void validate();
}

