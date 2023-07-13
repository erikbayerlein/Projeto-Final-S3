package com.example.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
// Essa classe é responsável por gerar e validar tokens JWT 
public class JwtService {
    // Métodos:
    // 1) Extrai o CPF contido no token JWT.
    public static String extractCPF(String token){
        return extractClaim(token, Claims::getSubject);
    }

    // 2) Gera um token JWT com base nos detalhes do usuário fornecidos. O token inclui o CPF como subject (assunto), a data de emissão (issuedAt) e a data de expiração (expiration).
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 3) Gera um token JWT sem claims extras. (Sobrecarga do método anterior)
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(0), userDetails);
    }

    // 4) Extrai uma claim específica do token JWT 
    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // 5) Extrai todas as claims do token JWT.
    private static Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 6) Verifica se um token JWT é válido
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String CPF = extractCPF(token);
        return CPF.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // 7) Verifica se o token JWT está expirado comparando a data de expiração do token com a data atual.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // 8) Extrai a data de expiração do token JWT.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // 9) Obtém a chave de assinatura usada para assinar e verificar os tokens JWT.
    private static Key getSigninKey() {
        String secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
