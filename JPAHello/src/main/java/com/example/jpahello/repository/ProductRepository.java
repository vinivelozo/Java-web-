package com.example.jpahello.repository;

import com.example.jpahello.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findAllByClientId(long client_id);
    @Transactional
    void deleteAllByClientId(long clientId);
}
