package com.fooddelivery.onlinefooddelivery.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

	// Secure random 256-bit secret key
	private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	// Generate token using email and role
	public String generateToken(String email, String role) {
		long currentTimeMillis = System.currentTimeMillis();
		return Jwts.builder().setSubject(email).claim("role", role).setIssuedAt(new Date(currentTimeMillis))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
				.signWith(SECRET_KEY).compact();
	}

	// Extract email from token
	public String extractEmail(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	// Extract role from token
	public String extractRole(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().get("role", String.class);
	}

	// Check if token is valid
	public boolean isTokenValid(String token, String email) {
		String extractedEmail = extractEmail(token);
		return extractedEmail.equals(email) && !isTokenExpired(token);
	}

	// Check if token is expired
	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
		return expiration.before(new Date());
	}
}
