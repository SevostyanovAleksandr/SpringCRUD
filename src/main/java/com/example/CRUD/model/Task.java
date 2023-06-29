package com.example.CRUD.model;

import jakarta.persistence.*;
import lombok.Data;


@Data // вместо гет сет и конст - ламбук
@Entity // данная сущность связана с БД
@Table(name = "task") //
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // для айдишника который инкремен авто
    private Long id;
    @Column(name = "task_date")
    private String task_date;
    @Column(name = "title")
    private String title;


}

