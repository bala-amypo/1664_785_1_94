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

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    
    private String jwtSecret = "testSecretKeyThatIsAtLeast32CharactersLong!";
    private long jwtExpirationInMs = 3600000;
    
    public void setJwtSecret(String secret) {
        this.jwtSecret = secret;
    }
    
    public void setJwtExpirationInMs(long expiration) {
        this.jwtExpirationInMs = expiration;
    }
    
    public String generateToken(org.springframework.security.core.Authentication authentication) {
        String username = authentication.getName();
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
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | 
                 UnsupportedJwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}