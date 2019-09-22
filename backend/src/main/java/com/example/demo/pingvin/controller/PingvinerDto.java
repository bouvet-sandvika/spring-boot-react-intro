package com.example.demo.pingvin.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PingvinerDto {
    @NotNull
    @Valid
    private List<PingvinDto> pingviner;

    public PingvinerDto(List<PingvinDto> pingviner) {
        this.pingviner = pingviner;
    }

    public List<PingvinDto> getPingviner() {
        return pingviner;
    }
}
