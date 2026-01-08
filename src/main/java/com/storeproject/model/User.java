package com.storeproject.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "User_id", nullable = false)
  protected Long ID;

  @Column(name = "First_name", nullable = false)
  public String First_name;

  @Column(name = "Last_name", nullable = false)
  public String Last_name;
  
  @Column (name = "User_email", nullable = false)
  public  String Email;

  @Column(name = "User_password", nullable = false)
  public  String Password;

   
}
