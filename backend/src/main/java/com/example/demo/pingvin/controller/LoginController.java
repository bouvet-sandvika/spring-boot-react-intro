package com.example.demo.pingvin.controller;

import com.example.demo.pingvin.exception.BadRequestException;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
@Validated
public class LoginController {

    private final GoogleIdTokenVerifier googleIdTokenVerifier;
    private final static String CLIENT_ID = "DIN_CLIENT_ID_KOMMER_HER";

    public LoginController() {
        googleIdTokenVerifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();
    }


    @PostMapping("/login")
    @Valid LoginDto login(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        try {
            GoogleIdToken idToken = googleIdTokenVerifier.verify(token);
            String innloggetBruker = idToken.getPayload().get("name").toString();
            return new LoginDto(innloggetBruker);

        } catch (GeneralSecurityException | IOException e) {
            // Kreves håndtert av av verify()
            throw new BadRequestException();
        }
    }
}
