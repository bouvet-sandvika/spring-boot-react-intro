package com.example.demo.pingvin.controller;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String innloggetBruker;

    public LoginDto(String innloggetBruker) {
        this.innloggetBruker = innloggetBruker;
    }

    public String getInnloggetBruker() {
        return innloggetBruker;
    }
}
