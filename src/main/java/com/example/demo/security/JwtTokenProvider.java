// package com.example.demo.security;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtTokenProvider {

//     public JwtTokenProvider() {
//     }

//     public String generateToken(
//             UsernamePasswordAuthenticationToken authentication,
//             long userId,
//             String email,
//             String role) {

//         return "test-token";
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtTokenProvider {
    
    private String jwtSecret = "testSecretKeyThatIsAtLeast32CharactersLong!";
    private long jwtExpirationInMs = 3600000;
    
    public void setJwtSecret(String secret) {
        this.jwtSecret = secret;
    }
    
    public void setJwtExpirationInMs(long expiration) {
        this.jwtExpirationInMs = expiration;
    }
    
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}