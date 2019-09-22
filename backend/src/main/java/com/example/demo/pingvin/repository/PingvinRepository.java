package com.example.demo.pingvin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PingvinRepository extends MongoRepository<PingvinEntity, String> {

}
