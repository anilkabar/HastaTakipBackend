package com.hastatakip.aut;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class TokenManager {

    //private static final String secretKey="haydiKodlayalim";
    private static final int validty=10*60*1000;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String   generateToken(String username, List<String> role,String userId){
        return Jwts.builder()
                .setSubject(username)
                .setId(userId)
                .setIssuer("hastatakipotomasyonu") //kimbunu imzaladı Oluşturdu
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+validty)) //nezamana kadar Geçerli
                .signWith(key)
                .claim("role",role)
                .compact();
    }
    public boolean tokenValidate(String token){
        if (getUserNameToken(token)!=null && isExpired(token)){
            return true;
        }
        return false;

    }
    public  String getUserNameToken(String token){
        Claims claims=getClaims(token);
        return claims.getSubject();
    }

    public boolean isExpired(String token){
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
