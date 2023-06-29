//для взаимодействия с  бд магия JPA
package com.example.CRUD.repository;

import com.example.CRUD.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

;

// где Task класс наш и Лонг айдишник
public interface TaskRepisitory extends JpaRepository <Task, Long> {

}