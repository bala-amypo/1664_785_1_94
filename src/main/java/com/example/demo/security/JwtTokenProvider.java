package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.util.Date;

public class JwtTokenProvider {

    private final String secret;

   
    public JwtTokenProvider(String secret) {
        this.secret = secret;
    }

    
    public String generateToken(String subject, long expirationMillis) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMillis);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    public String getSubject(String token) {
        return getClaimsFromToken(token).getSubject();
    }
}
