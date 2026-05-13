package com.xuan.clientcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xuan.clientcrud.document.Client;

public interface ClientRepository extends MongoRepository<Client, String>{

}
