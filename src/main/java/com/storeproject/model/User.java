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
  protected Long Id;

  @Column(name = "user_first_name", nullable = false)
  public String firstName;

  @Column(name = "user_last_name", nullable = false)
  public String lastName;

  @Column (name = "user_email", nullable = false)
  public  String email;

  @Column(name = "user_password", nullable = false)
  public  String Password;

   
}
