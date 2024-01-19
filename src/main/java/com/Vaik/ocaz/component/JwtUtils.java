package com.Vaik.ocaz.component;


// import com.codesimple.bookstore.common.AccessDeniedException;
import com.Vaik.ocaz.model.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.boot.autoconfigure.ssl.SslBundleProperties.Key;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static String secret = "This";
    java.security.Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static long expiryDuration = 60 * 60;

    public String generateJwt(Utilisateur user){

        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        // claims
        Claims claims = Jwts.claims()
                .setIssuer(String.valueOf(user.getNom()))
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        // optional claims
        // claims.put("type", user.getUserType());
        claims.put("name", user.getNom());
        claims.put("email", user.getEmail());

        // generate jwt using c laims
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new Exception("Access Denied");
        }

    }
}