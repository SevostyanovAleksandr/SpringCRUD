package com.example.CRUD.model;


import jakarta.persistence.*;
import lombok.Data;

@Data // вместо гет сет и конст - ламбук
@Entity // данная сущность связана с БД
@Table( name = "users") //
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // для айдишника который инкремен авто
    private Long id;
@Column(name = "email")
    private String email;
@Column(name = "password")
    private String password;
@Column (name = "username")
    private String username;

}
