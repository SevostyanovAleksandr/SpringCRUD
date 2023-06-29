package com.example.CRUD.repository;

//для взаимодействия с  бд магия JPA


import com.example.CRUD.model.Owner;

import org.springframework.data.jpa.repository.JpaRepository;


// где User класс наш и Лонг айдишник
public interface OwnerRepository extends JpaRepository<Owner, Long> {
//List<User> findByUsername (String username);
}
