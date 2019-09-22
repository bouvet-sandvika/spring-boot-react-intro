package com.example.demo.pingvin.controller;

import com.example.demo.pingvin.repository.PingvinEntity;
import com.example.demo.pingvin.repository.PingvinRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@Validated
public class PingvinController {

    private PingvinRepository pingvinRepository;

    public PingvinController(PingvinRepository pingvinRepository) {
        this.pingvinRepository = pingvinRepository;
    }

    @GetMapping("/pingviner")
    @Valid PingvinerDto hentAllePingviner() {
        return new PingvinerDto(
                pingvinRepository
                        .findAll()
                        .stream()
                        .map(PingvinController::mapTilPingvinDto)
                        .collect(Collectors.toList()));
    }

    @PostMapping("/pingviner")
    PingvinDto lagrePingvin(@RequestBody @Valid PingvinDto pingvin) {
        PingvinEntity lagretPingvin = pingvinRepository.save(mapTilPingvinEntity(pingvin));
        return mapTilPingvinDto(lagretPingvin);
    }

    @GetMapping("/ping")
    ResponseEntity ping() {
        return ResponseEntity.ok("pong");
    }

    private static PingvinDto mapTilPingvinDto(PingvinEntity entity) {
        return new PingvinDto(entity.getNavn());
    }

    private static PingvinEntity mapTilPingvinEntity(PingvinDto dto) {
        return new PingvinEntity(dto.getNavn());
    }
}
