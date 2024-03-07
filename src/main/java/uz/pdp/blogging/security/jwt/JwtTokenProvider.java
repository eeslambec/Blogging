package uz.pdp.blogging.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.pdp.blogging.entity.User;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    @Value("${jwt.token.secret.key}")
    private String key;
    @Value("${jwt.token.secret.expiry}")
    private String expiry;
    public String generateToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(expiry)))
                .signWith(key())
                .compact();
    }
    public String generateForEmail(User user){
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .claim("username",user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(key())
                .compact();
    }
    public boolean isValid(String token) {
        Claims claims = parseAllClaims(token);
        Date date = extractExpiryDate(claims);
        return date.after(new Date());
    }
    public Claims parseAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(key())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Date extractExpiryDate(Claims claims) {
        return claims.getExpiration();
    }

    public SecretKey key() {
        return Keys.hmacShaKeyFor(key.getBytes());
    }
}
