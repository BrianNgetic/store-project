package com.storeproject.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users implements UserDetails{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  protected Long Id;

  @Column(name = "username", nullable = false)
  protected String username;

   @Column (name = "password", nullable = false)
  public String password;


  @Column(name = "fullname", nullable = false)
  public String fullname;

  @Column (name = "email", nullable = false)
  public  String email;

  @Column (name = "address")
  public String address;

  @Column(name = "city")
  public String city;

  @Column(name = "state")
  public String state;

  @Column(name = "zip")
  public String zip;


  public Users (
      String username,
      String password,
      String fullname,
      String email,
      String address,
      String city,
      String state,
      String zip){
        this.username = username;
        this.password  = password;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;

      
      }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public boolean isAccountNonExpired() {
   return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
   return  true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }




 





   
}
