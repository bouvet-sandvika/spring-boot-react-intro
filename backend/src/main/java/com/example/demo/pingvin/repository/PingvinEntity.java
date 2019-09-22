package com.example.demo.pingvin.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Pingviner")
public class PingvinEntity {

    @Id
    private String id;

    private String navn;

    public PingvinEntity(String navn){
        this.navn = navn;
    }

    public String getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }
}
