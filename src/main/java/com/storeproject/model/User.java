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
  @Column(name = "user_id", nullable = false)
  protected Long ID;

  @Column(name = "user_first_name", nullable = false)
  public String First_name;

  @Column(name = "user_last_name", nullable = false)
  public String Last_name;

  @Column (name = "user_email", nullable = false)
  public  String Email;

  @Column(name = "user_password", nullable = false)
  public  String Password;

   
}
