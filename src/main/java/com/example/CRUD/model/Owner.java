package com.example.CRUD.model;

import jakarta.persistence.*;
import lombok.Data;


@Data // вместо гет сет и конст - ламбук
@Entity // данная сущность связана с БД
@Table(name = "owner") //
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // для айдишника который инкремен авто
    private Long id;
    @Column(name = "project")
    private String project;
    @Column(name = "responsible")
    private String responsible;


}

