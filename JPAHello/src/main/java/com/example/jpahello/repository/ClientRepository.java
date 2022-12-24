package com.example.jpahello.repository;

import com.example.jpahello.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public List<Client> findAllByFirstNameIgnoreCase(String firstName);
}
