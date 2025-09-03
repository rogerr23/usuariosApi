package com.rogerr.components;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtBearerComponent {

	@Value("${jwt.secretkey}")
	private String jwtSecret;

	@Value("${jwt.expiration}")
	private String jwtExpiration;

	public Date getExpiration() {
		var dataAtual = new Date();
		return new Date(dataAtual.getTime() + Integer.parseInt(jwtExpiration));
	}

	public String getToken(String emailUsuario) {
		return Jwts.builder().setSubject(emailUsuario).setIssuedAt(new Date()).setExpiration(getExpiration())
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

}
