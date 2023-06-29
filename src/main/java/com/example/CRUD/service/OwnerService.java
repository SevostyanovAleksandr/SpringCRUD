package com.example.CRUD.service;

import com.example.CRUD.model.Owner;
import com.example.CRUD.model.User;
import com.example.CRUD.repository.OwnerRepository;
import com.example.CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


// бизнес логика
// некий запрос который мы будем принимать из внешнего мира
@Service

public class OwnerService {

  private final OwnerRepository ownerRepository;
    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner findById(Long id) {
        return ownerRepository.getOne(id);
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void deletedById(Long id) {
        ownerRepository.deleteById(id);
    }
}
