package br.com.alura.forum.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;

	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {

		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDateTime localDateHoje = LocalDateTime.now();
		Long milis = localDateHoje.atZone(defaultZoneId).toInstant().toEpochMilli();
		Long expiracao = Long.valueOf(expiration) + milis;

		Date hoje = Date.from(localDateHoje.atZone(defaultZoneId).toInstant());
		Date dataExpiracao = Date.from(Instant.ofEpochMilli(expiracao));

		Usuario logado = (Usuario) authentication.getPrincipal();

		return Jwts.builder().setIssuer("API FORUM ALURA")
				.setSubject(logado.getId().toString()).setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isTokenValido(String token) {
		
		try {
		Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
		return true;
		}catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret)
		.parseClaimsJws(token).getBody();
		
		return Long.parseLong(body.getSubject());
	}

}
