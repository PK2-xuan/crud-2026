package com.xuan.clientcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xuan.clientcrud.document.Client;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {

    // filter
    List<Client> findByNombre(String nombre);
}
