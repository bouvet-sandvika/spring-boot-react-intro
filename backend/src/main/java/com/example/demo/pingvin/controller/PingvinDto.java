package com.example.demo.pingvin.controller;

import javax.validation.constraints.NotBlank;

public class PingvinDto {

    public PingvinDto() {
    }

    public PingvinDto(String navn) {
        this.navn = navn;
    }

    @NotBlank
    private String navn;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
