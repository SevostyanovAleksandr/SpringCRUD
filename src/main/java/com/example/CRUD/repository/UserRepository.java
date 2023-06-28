//для взаимодействия с  бд магия JPA
package com.example.CRUD.repository;

import com.example.CRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

;

// где User класс наш и Лонг айдишник
public interface UserRepository extends JpaRepository <User, Long> {
//List<User> findByUsername (String username);
}
