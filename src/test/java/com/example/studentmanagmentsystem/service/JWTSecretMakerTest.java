package com.example.studentmanagmentsystem.service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Base64;

public class JWTSecretMakerTest {

    @Test
    public void generateSecretKey() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Secret Key: " + encodedKey);
    }
}